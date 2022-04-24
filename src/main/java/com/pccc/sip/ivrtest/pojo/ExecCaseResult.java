package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class ExecCaseResult {
    private Integer id;

    private String execCaseId;

    private String execResult;

    private String execState;

    private String tranInfo;

    private String callId;

    private Date startTime;

    private Date endTime;

    @TableField(exist = false)
    private String execInfo;

    public String getExecInfo() {
        return execInfo;
    }

    public void setExecInfo(String execInfo) {
        this.execInfo = execInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecCaseId() {
        return execCaseId;
    }

    public void setExecCaseId(String execCaseId) {
        this.execCaseId = execCaseId == null ? null : execCaseId.trim();
    }

    public String getExecResult() {
        return execResult;
    }

    public void setExecResult(String execResult) {
        this.execResult = execResult == null ? null : execResult.trim();
    }

    public String getExecState() {
        return execState;
    }

    public void setExecState(String execState) {
        this.execState = execState == null ? null : execState.trim();
    }

    public String getTranInfo() {
        return tranInfo;
    }

    public void setTranInfo(String tranInfo) {
        this.tranInfo = tranInfo == null ? null : tranInfo.trim();
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId == null ? null : callId.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}