package com.pccc.sip.ivrtest.service.impl;

import com.pccc.sip.ivrtest.config.JedisTemplate;
import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.entity.FillDataRequest;
import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.ExecCaseResultMapper;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.ExecuteEngineService;
import com.pccc.sip.ivrtest.util.GsonUtil;
import io.leaderli.litil.meta.Lino;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExecuteEngineServiceImpl implements ExecuteEngineService {

    private static final String EXECINFO="exec_info_";
    @Autowired
    private ExecCaseMapper execCaseMapper;
    @Autowired
    private ExecCaseResultMapper execCaseResultMapper;
    @Autowired
    private TestCaseMapper testCaseMapper;
    @Autowired
    private JedisTemplate jedisTemplate;
    @Autowired
    private CommonService commonService;

    @Override
    public ExecCase queryExecCaseById(String id) {
        return execCaseMapper.queryById(id);
    }

    @Override
    public int modifyExecCaseById(ExecCase execCase) {
        return execCaseMapper.updateById(execCase);
    }

    @Override
    public TestCase queryTestCaseById(String id) {
        return testCaseMapper.selectById(id);
    }

    @Override
    public int modifyTestCaseById(TestCase execCase) {
        return testCaseMapper.updateById(execCase);
    }

    @Override
    public void modifyCaseById(TestCase testCase, ExecCase execCase) {
        testCaseMapper.updateTestCaseById(testCase);
        execCaseMapper.updateExecCaseById(execCase);
    }

    @Override
    public void addExecCaseResult(ExecCaseResult execCaseResult) {
        if (1 == execCaseResultMapper.addExecCaseResult(execCaseResult)) {
            if (null != execCaseResult.getId() && StringUtils.isNotBlank(execCaseResult.getExecInfo())) {
                jedisTemplate.setCacheWithExpireTime(EXECINFO + execCaseResult.getId(), execCaseResult.getExecInfo(), 7 * 24 * 60 * 60 * 1000L);
            }
        }
    }

    @Override
    public String queryExecInfoById(String id) {
        return jedisTemplate.get(id);
    }

    @Override
    public boolean addBatchExecCase(FillDataRequest fillDataRequest) {

        List<ExecCase> execCases = new ArrayList<>();
        for (ExecuteCaseRequest executeCaseRequest: Lino.of(fillDataRequest).map(FillDataRequest::getList).get()){
            ExecCase execCase = new ExecCase();
            execCase.setId(commonService.creatExecCaseId());
            execCase.setCaseDesc(executeCaseRequest.getCaseDesc());
            execCase.setBatch(Integer.valueOf(fillDataRequest.getExecuteBatchNo()));
            execCase.setParams(GsonUtil.GsonString(executeCaseRequest.getVariableData()));
            execCase.setIsUsed(Type.ENABLE.getType());
            execCase.setTestCaseId(executeCaseRequest.getCaseId());
            execCase.setPreExecCaseId(executeCaseRequest.getExecuteId());
            execCase.setIsArchived(Type.DISABLE.getType());
            execCase.setExecTimes(0);
            execCases.add(execCase);
        }
        return execCaseMapper.insertBatch(execCases);
    }


}
