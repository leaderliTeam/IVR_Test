package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;
import java.util.List;

public class TestCase {
    @TableField(value = "id")
    private String id;
    @TableField(value = "case_desc")
    private String caseDesc;
    @TableField(value = "input_seq")
    private String inputSeq;
    @TableField(exist = false)
    private String expResultRule;
    @TableField(value = "is_used")
    private String used;
    @TableField(value = "demand_id")
    private String reqId;
    @TableField(value = "principal_test")
    private String tester;
    @TableField(value = "principal_develop")
    private String developer;
    @TableField(value = "pre_case_id")
    private String frontCaseId;
    @TableField(value = "exec_times")
    private String executeNum;
    @TableField(value = "last_time", fill = FieldFill.INSERT_UPDATE)
    private Date lastExecuteTime;
    @TableField(value = "edit_state")
    private String editState;
    @TableField(value = "tag")
    private String tag;
    private List<TestCase> children;

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

    public String getInputSeq() {
        return inputSeq;
    }

    public void setInputSeq(String inputSeq) {
        this.inputSeq = inputSeq;
    }

    public String getExpResultRule() {
        return expResultRule;
    }

    public void setExpResultRule(String expResultRule) {
        this.expResultRule = expResultRule;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getFrontCaseId() {
        return frontCaseId;
    }

    public void setFrontCaseId(String frontCaseId) {
        this.frontCaseId = frontCaseId;
    }

    public String getExecuteNum() {
        return executeNum;
    }

    public void setExecuteNum(String executeNum) {
        this.executeNum = executeNum;
    }

    public Date getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Date lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public String getEditState() {
        return editState;
    }

    public void setEditState(String editState) {
        this.editState = editState;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<TestCase> getChildren() {
        return children;
    }

    public void setChildren(List<TestCase> children) {
        this.children = children;
    }
}