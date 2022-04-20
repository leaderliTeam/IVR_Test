package com.pccc.sip.ivrtest.entity;

import java.util.HashMap;
import java.util.List;

public class FillDataRequest {

    private String executeBatchNo;
    private HashMap<String,String> variableData;
    private List<ExecuteCaseEntity> list;

    public String getExecuteBatchNo() {
        return executeBatchNo;
    }

    public void setExecuteBatchNo(String executeBatchNo) {
        this.executeBatchNo = executeBatchNo;
    }

    public HashMap<String, String> getVariableData() {
        return variableData;
    }

    public void setVariableData(HashMap<String, String> variableData) {
        this.variableData = variableData;
    }

    public List<ExecuteCaseEntity> getList() {
        return list;
    }

    public void setList(List<ExecuteCaseEntity> list) {
        this.list = list;
    }
}
