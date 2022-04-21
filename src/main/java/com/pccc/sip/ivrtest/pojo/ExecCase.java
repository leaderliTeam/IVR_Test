package com.pccc.sip.ivrtest.pojo;

import com.pccc.sip.ivrtest.annotation.ExcelIndex;
import com.pccc.sip.ivrtest.constant.Type;

import java.util.Date;

public class ExecCase {

    @ExcelIndex(index = 0)
    private String id;
    @ExcelIndex(index = 1)
    private Integer batch;
    @ExcelIndex(index = 2)
    private String caseDesc;
    @ExcelIndex(index = 3)
    private String params;
    @ExcelIndex(index =4)
    private String isUsed;
    @ExcelIndex(index = 5)
    private String testCaseId;
    @ExcelIndex(index = 6)
    private String preExecCaseId;
    @ExcelIndex(index = 7)
    private String isArchived;
    @ExcelIndex(index = 8)
    private Integer execTimes;
    @ExcelIndex(index = 9,type = Type.AttributeType.DATE)
    private Date lastTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc == null ? null : caseDesc.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId == null ? null : testCaseId.trim();
    }

    public String getPreExecCaseId() {
        return preExecCaseId;
    }

    public void setPreExecCaseId(String preExecCaseId) {
        this.preExecCaseId = preExecCaseId == null ? null : preExecCaseId.trim();
    }

    public String getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(String isArchived) {
        this.isArchived = isArchived == null ? null : isArchived.trim();
    }

    public Integer getExecTimes() {
        return execTimes;
    }

    public void setExecTimes(Integer execTimes) {
        this.execTimes = execTimes;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "ExecCase{" +
                "id='" + id + '\'' +
                ", batch=" + batch +
                ", caseDesc='" + caseDesc + '\'' +
                ", params='" + params + '\'' +
                ", isUsed='" + isUsed + '\'' +
                ", testCaseId='" + testCaseId + '\'' +
                ", preExecCaseId='" + preExecCaseId + '\'' +
                ", isArchived='" + isArchived + '\'' +
                ", execTimes=" + execTimes +
                ", lastTime=" + lastTime +
                '}';
    }
}