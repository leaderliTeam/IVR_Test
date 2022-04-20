package com.pccc.sip.ivrtest.entity;

import com.pccc.sip.ivrtest.annotation.ExcelIndex;
import com.pccc.sip.ivrtest.constant.Type;

import java.util.HashMap;

public class ExecuteCaseEntity{

    @ExcelIndex(index = 0)
    private String id;
    @ExcelIndex(index = 2)
    private String caseDesc;
    @ExcelIndex(index = 1)
    private String executeBatchNo;
    @ExcelIndex(index = 3,type = Type.AttributeType.MAP)
    private HashMap<String,String> variableData;
    private String used;
    @ExcelIndex(index = 4)
    private String caseId;
    @ExcelIndex(index = 5)
    private String executeId;
    private String archiveStatus;
    private String executeCount;
    private String lastExecuteTime;

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

    public String getExecuteCount() {
        return executeCount;
    }

    public void setExecuteCount(String executeCount) {
        this.executeCount = executeCount;
    }

    public String getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(String lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    @Override
    public String toString() {
        return "ExecuteCaseEntity{" +
                "id='" + id + '\'' +
                ", caseDesc='" + caseDesc + '\'' +
                ", executeBatchNo='" + executeBatchNo + '\'' +
                ", variableData=" + variableData +
                ", used='" + used + '\'' +
                ", caseId='" + caseId + '\'' +
                ", executeId='" + executeId + '\'' +
                ", archiveStatus='" + archiveStatus + '\'' +
                ", executeCount='" + executeCount + '\'' +
                ", lastExecuteTime='" + lastExecuteTime + '\'' +
                '}';
    }
}
