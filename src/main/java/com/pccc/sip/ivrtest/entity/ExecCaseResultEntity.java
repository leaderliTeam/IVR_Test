package com.pccc.sip.ivrtest.entity;

import com.pccc.sip.ivrtest.annotation.ExcelIndex;
import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.util.GsonUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class ExecCaseResultEntity {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ExcelIndex(index = 0)
    private String id;
    @ExcelIndex(index = 2)
    private String caseDesc;
    @ExcelIndex(index = 1)
    private String executeBatchNo;
    @ExcelIndex(index = 3,type = Type.AttributeType.MAP)
    private HashMap<String, String> variableData;
    @ExcelIndex(index = 4)
    private String used;
    @ExcelIndex(index = 5)
    private String caseId;
    @ExcelIndex(index = 6)
    private String executeId;
    @ExcelIndex(index = 7)
    private String archiveStatus;
    @ExcelIndex(index = 8)
    private String executeCount;
    @ExcelIndex(index = 9)
    private String lastExecuteTime;
    private String execCaseId;
    @ExcelIndex(index = 12)
    private String execResult;
    @ExcelIndex(index = 14)
    private String execState;
    @ExcelIndex(index = 11,type = Type.AttributeType.MAP)
    private HashMap<String, String> tranInfo;
    @ExcelIndex(index = 10)
    private String callId;
    @ExcelIndex(index = 15)
    private String startTime;
    @ExcelIndex(index = 16)
    private String endTime;
    @ExcelIndex(index = 13,type = Type.AttributeType.MAP)
    private HashMap<String, String> execInfo;

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

    public HashMap<String, String> getVariableData() {
        return variableData;
    }

    public void setVariableData(HashMap<String, String> variableData) {
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

    public String getExecCaseId() {
        return execCaseId;
    }

    public void setExecCaseId(String execCaseId) {
        this.execCaseId = execCaseId;
    }

    public String getExecResult() {
        return execResult;
    }

    public void setExecResult(String execResult) {
        this.execResult = execResult;
    }

    public String getExecState() {
        return execState;
    }

    public void setExecState(String execState) {
        this.execState = execState;
    }

    public HashMap<String, String> getTranInfo() {
        return tranInfo;
    }

    public void setTranInfo(HashMap<String, String> tranInfo) {
        this.tranInfo = tranInfo;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public HashMap<String, String> getExecInfo() {
        return execInfo;
    }

    public void setExecInfo(HashMap<String, String> execInfo) {
        this.execInfo = execInfo;
    }

    public void setExecCase(ExecCase execCase){
        this.id = execCase.getId();
        this.executeBatchNo = String.valueOf(execCase.getBatch());
        this.caseDesc = execCase.getCaseDesc();
        this.variableData = GsonUtil.GsonToBean(execCase.getParams(),HashMap.class);
        this.used = execCase.getIsUsed();
        this.caseId = execCase.getTestCaseId();
        this.executeId = execCase.getPreExecCaseId();
        this.archiveStatus = execCase.getIsArchived();
        this.executeCount = String.valueOf(execCase.getExecTimes());
        this.lastExecuteTime = format.format(execCase.getLastTime());
    }

    public void setExecCaseResult(ExecCaseResult execCaseResult){
        this.execCaseId = execCaseResult.getExecCaseId();
        this.execResult = execCaseResult.getExecResult();
        this.execState = execCaseResult.getExecState();
        this.tranInfo = GsonUtil.GsonToBean(execCaseResult.getTranInfo(),HashMap.class);
        this.callId = execCaseResult.getCallId();
        this.startTime = format.format(execCaseResult.getStartTime());
        this.endTime = format.format(execCaseResult.getEndTime());
    }

    @Override
    public String toString() {
        return "ExecCaseResultEntity{" +
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
                ", execCaseId='" + execCaseId + '\'' +
                ", execResult='" + execResult + '\'' +
                ", execState='" + execState + '\'' +
                ", tranInfo=" + tranInfo +
                ", callId='" + callId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", execInfo=" + execInfo +
                '}';
    }
}