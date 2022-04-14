package com.pccc.sip.ivrtest.entity;

import com.google.gson.JsonObject;

import java.util.HashMap;

public class ExecuteCaseRequest extends BaseRequest{

    private String id;
    private String caseDesc;
    private String executeBatchNo;
    private HashMap<String,String> variableData;
    private String used;
    private String caseId;
    private String executeId;
    private String archiveStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    public String getExecuteBatchNo() {
        return executeBatchNo;
    }

    public void setExecuteBatchNo(String executeBatchNo) {
        this.executeBatchNo = executeBatchNo;
    }

    public HashMap<String,String> getVariableData() {
        return variableData;
    }

    public void setVariableData(HashMap<String,String> variableData) {
        this.variableData = variableData;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }

}
