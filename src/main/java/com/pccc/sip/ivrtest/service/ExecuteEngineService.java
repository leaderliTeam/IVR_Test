package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.pojo.TestCase;

public interface ExecuteEngineService {

    public ExecCase queryExecCaseById(String id);
    public int modifyExecCaseById(ExecCase execCase);

    public TestCase queryTestCaseById(String id);
    public int modifyTestCaseById(TestCase testCase);

    public void modifyCaseById(TestCase testCase,ExecCase execCase);

    public void addExecCaseResult(ExecCaseResult execCaseResult);

    public String queryExecInfoById(String id);

}
