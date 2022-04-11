package com.pccc.sip.ivrtest.pojo;

import java.util.Date;

public class TestCase {
    private String id;

    private String caseDesc;

    private String inputSeq;

    private String isUsed;

    private String demandId;

    private String principalTest;

    private String principalDevelop;

    private String preCaseId;

    private String editState;

    private Integer execTimes;

    private Date lastTime;

    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc == null ? null : caseDesc.trim();
    }

    public String getInputSeq() {
        return inputSeq;
    }

    public void setInputSeq(String inputSeq) {
        this.inputSeq = inputSeq == null ? null : inputSeq.trim();
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId == null ? null : demandId.trim();
    }

    public String getPrincipalTest() {
        return principalTest;
    }

    public void setPrincipalTest(String principalTest) {
        this.principalTest = principalTest == null ? null : principalTest.trim();
    }

    public String getPrincipalDevelop() {
        return principalDevelop;
    }

    public void setPrincipalDevelop(String principalDevelop) {
        this.principalDevelop = principalDevelop == null ? null : principalDevelop.trim();
    }

    public String getPreCaseId() {
        return preCaseId;
    }

    public void setPreCaseId(String preCaseId) {
        this.preCaseId = preCaseId == null ? null : preCaseId.trim();
    }

    public String getEditState() {
        return editState;
    }

    public void setEditState(String editState) {
        this.editState = editState == null ? null : editState.trim();
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}