package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pccc.sip.ivrtest.config.JedisTemplate;
import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.entity.ExecCaseResultEntity;
import com.pccc.sip.ivrtest.entity.request.QueryECResPageRequest;
import com.pccc.sip.ivrtest.entity.response.QueryECResPageResponse;
import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.ExecCaseResultMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.service.ExecuteCaseResultService;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExecuteCaseResultServiceImpl implements ExecuteCaseResultService {

    @Autowired
    private ExecCaseMapper execCaseMapper;
    @Autowired
    private ExecCaseResultMapper execCaseResultMapper;
    @Autowired
    private JedisTemplate jedisTemplate;

    @Override
    public QueryECResPageResponse queryByPage(QueryECResPageRequest queryECResPageRequest) {
        Page<ExecCaseResult> page = new Page<>(queryECResPageRequest.getCurrentPage(),queryECResPageRequest.getPageSize());
        QueryWrapper<ExecCaseResult> execCaseResultQueryWrapper = new QueryWrapper<>();
        execCaseResultQueryWrapper.eq("exec_case_id",queryECResPageRequest.getId());
        execCaseResultMapper.selectPage(page,execCaseResultQueryWrapper);
        QueryECResPageResponse queryECResPageResponse = new QueryECResPageResponse();
        queryECResPageResponse.setPageInfo(page);
        queryECResPageResponse.setList(ecResToECResEntitys(page.getRecords()));
        return queryECResPageResponse;
    }


    private List<ExecCaseResultEntity> ecResToECResEntitys(List<ExecCaseResult> execCaseResults){
        List<ExecCaseResultEntity> execCaseResultEntities = new ArrayList<>();
        for (ExecCaseResult execCaseResult:execCaseResults){
            ExecCaseResultEntity execCaseResultEntity = new ExecCaseResultEntity();
            execCaseResultEntity.setId(String.valueOf(execCaseResult.getId()));
            execCaseResultEntity.setExecCaseResult(execCaseResult);
            execCaseResultEntities.add(execCaseResultEntity);
        }
        return execCaseResultEntities;
    }

    @Override
    public List<ExecCaseResultEntity> queryAllList(String id) {
        return getExecCaseResultEntitys(id);
    }

    private List<ExecCaseResultEntity> getExecCaseResultEntitys(String id) {
        ExecCase execCase = execCaseMapper.queryById(id);
        QueryWrapper<ExecCaseResult> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exec_case_id", id);
        List<ExecCaseResult> execCaseResults = execCaseResultMapper.selectList(queryWrapper);
        return execCaseResToEntity(execCase,execCaseResults);
    }

    private List<ExecCaseResultEntity> execCaseResToEntity(ExecCase execCase, List<ExecCaseResult> execCaseResults) {
        List<ExecCaseResultEntity> list = new ArrayList<>();
        for (ExecCaseResult execCaseResult : execCaseResults) {
            ExecCaseResultEntity execCaseResultEntity = new ExecCaseResultEntity();
            execCaseResultEntity.setExecCase(execCase);
            execCaseResultEntity.setExecCaseResult(execCaseResult);
            String execInfo = jedisTemplate.get(Type.EXECINFO.getType() + execCaseResult.getId());
            execCaseResultEntity.setExecInfo(StringUtils.isBlank(execInfo) ? null : GsonUtil.GsonToBean(execInfo, HashMap.class));
            list.add(execCaseResultEntity);
        }
        return list;
    }


}
