package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class ExpResultRule {
    @TableField(value = "id")
    private int id;
    @TableField(value = "test_case_id")
    private String testCaseId;
    @TableField(value = "order_id")
    private String orderId;
    @TableField(value = "rule_type")
    private String ruleType;
    @TableField(value = "rule_value")
    private String ruleValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public void setRuleValue(String ruleValue) {
        this.ruleValue = ruleValue;
    }
}
