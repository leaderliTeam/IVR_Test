package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.entity.FillDataRequest;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.pojo.TestCase;

import java.util.List;

public interface ExecuteEngineService {

    ExecCase queryExecCaseById(String id);
    int modifyExecCaseById(ExecCase execCase);

    TestCase queryTestCaseById(String id);
    int modifyTestCaseById(TestCase testCase);

    void modifyCaseById(TestCase testCase, ExecCase execCase);

    void addExecCaseResult(ExecCaseResult execCaseResult);

    String queryExecInfoById(String id);

}
