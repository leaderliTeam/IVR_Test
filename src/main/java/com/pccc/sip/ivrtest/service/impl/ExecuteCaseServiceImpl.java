package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;
import com.pccc.sip.ivrtest.entity.request.FillDataRequest;
import com.pccc.sip.ivrtest.entity.request.QueryExecCasePageRequest;
import com.pccc.sip.ivrtest.entity.response.QueryExecCasePageResponse;
import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.ExecuteCaseService;
import com.pccc.sip.ivrtest.util.GsonUtil;
import io.leaderli.litil.meta.Lino;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExecuteCaseServiceImpl implements ExecuteCaseService {

    @Autowired
    private ExecCaseMapper execCaseMapper;
    @Autowired
    private CommonService commonService;
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    @Override
    public boolean addBatchExecCase(FillDataRequest fillDataRequest) {
        return insertBatchExecCase(Lino.of(fillDataRequest).map(FillDataRequest::getList).get(),fillDataRequest.getExecuteBatchNo(),fillDataRequest.getVariableData());
    }

    @Override
    public int addExecCase(ExecuteCaseEntity executeCaseEntity) {
        return execCaseMapper.insert(executeCaseRequestToExecCase(executeCaseEntity,null,null));
    }

    @Override
    public QueryExecCasePageResponse queryByPage(QueryExecCasePageRequest queryExecCasePageRequest) {

        Page<ExecCase> page = new Page<>(queryExecCasePageRequest.getCurrentPage(),queryExecCasePageRequest.getPageSize());
        QueryWrapper<ExecCase> execCaseQueryWrapper = new QueryWrapper<>();
        queryWrapperEq(execCaseQueryWrapper,"id",queryExecCasePageRequest.getId());
        queryWrapperEq(execCaseQueryWrapper,"batch",queryExecCasePageRequest.getExecuteBatchNo());
        if (!StringUtils.equals(Type.ALL.getType(),queryExecCasePageRequest.getUsed())){
            queryWrapperEq(execCaseQueryWrapper,"isUsed",queryExecCasePageRequest.getUsed());
        }
        if (!StringUtils.equals(Type.ALL.getType(),queryExecCasePageRequest.getArchiveStatus())) {
            queryWrapperEq(execCaseQueryWrapper,"isArchived", queryExecCasePageRequest.getArchiveStatus());
        }
        execCaseMapper.selectPage(page,execCaseQueryWrapper);

        QueryExecCasePageResponse queryExecCasePageResponse = new QueryExecCasePageResponse();
        queryExecCasePageResponse.setPageInfo(page);
        queryExecCasePageResponse.setList(execCasesToExecuteCaseEntitys(page.getRecords()));
        return queryExecCasePageResponse;
    }

    @Override
    public int updateById(ExecuteCaseEntity executeCaseEntity) {
        ExecCase execCase = new ExecCase();
        execCase.setId(executeCaseEntity.getId());
        execCase.setCaseDesc(executeCaseEntity.getCaseDesc());
        execCase.setBatch(Integer.valueOf(executeCaseEntity.getExecuteBatchNo()));
        execCase.setParams(GsonUtil.GsonString(executeCaseEntity.getVariableData()));
        execCase.setIsUsed(executeCaseEntity.getUsed());
        execCase.setTestCaseId(executeCaseEntity.getCaseId());
        execCase.setPreExecCaseId(executeCaseEntity.getExecuteId());
        execCase.setIsArchived(executeCaseEntity.getArchiveStatus());
        return execCaseMapper.updateById(execCase);
    }

    @Override
    public int deleteBatchIds(List<String> idList) {
        return execCaseMapper.deleteBatchIds(idList);
    }

    @Override
    public boolean insertBatchExecCase(List<ExecuteCaseEntity> list,String executeBatchNo,HashMap<String,String> map) {
        List<ExecCase> execCases = new ArrayList<>();
        for (ExecuteCaseEntity executeCaseEntity : list){
            execCases.add(executeCaseRequestToExecCase(executeCaseEntity,executeBatchNo,map));
        }
        return execCaseMapper.insertBatch(execCases);

    }

    private void queryWrapperEq(QueryWrapper execCaseQueryWrapper,String key,String value){
        if (StringUtils.isNotBlank(value)){
            execCaseQueryWrapper.eq(key,value);
        }
    }

    private List<ExecuteCaseEntity> execCasesToExecuteCaseEntitys(List<ExecCase> execCases){
        List<ExecuteCaseEntity> caseEntityList = new ArrayList<>();
        for (ExecCase execCase:execCases){
            ExecuteCaseEntity executeCaseEntity = new ExecuteCaseEntity();
            executeCaseEntity.setId(execCase.getId());
            executeCaseEntity.setCaseId(execCase.getTestCaseId());
            executeCaseEntity.setExecuteId(execCase.getPreExecCaseId());
            executeCaseEntity.setCaseDesc(execCase.getCaseDesc());
            executeCaseEntity.setExecuteBatchNo(String.valueOf(execCase.getBatch()));
            executeCaseEntity.setArchiveStatus(execCase.getIsArchived());
            executeCaseEntity.setUsed(execCase.getIsUsed());
            executeCaseEntity.setExecuteCount(String.valueOf(execCase.getExecTimes()));
            executeCaseEntity.setLastExecuteTime(execCase.getLastTime() == null ? null : format.format(execCase.getLastTime()));
            executeCaseEntity.setVariableData(GsonUtil.GsonToBean(execCase.getParams(), HashMap.class));
            caseEntityList.add(executeCaseEntity);
        }
        return caseEntityList;
    }

    private ExecCase executeCaseRequestToExecCase(ExecuteCaseEntity executeCaseEntity, String executeBatchNo,HashMap<String,String> map){
        ExecCase execCase = new ExecCase();
        String id = StringUtils.isNotBlank(executeCaseEntity.getId())? executeCaseEntity.getId():commonService.creatExecCaseId();
        execCase.setId(id);
        execCase.setCaseDesc(executeCaseEntity.getCaseDesc());
        Integer batchNo = Integer.valueOf(StringUtils.isNotBlank(executeBatchNo)?executeBatchNo: executeCaseEntity.getExecuteBatchNo());
        execCase.setBatch(batchNo);
        execCase.setParams(GsonUtil.GsonString(map!=null ? map :executeCaseEntity.getVariableData()));
        execCase.setIsUsed(Type.ENABLE.getType());
        execCase.setTestCaseId(executeCaseEntity.getCaseId());
        execCase.setPreExecCaseId(executeCaseEntity.getExecuteId());
        execCase.setIsArchived(Type.DISABLE.getType());
        execCase.setExecTimes(0);
        return execCase;
    }
}
