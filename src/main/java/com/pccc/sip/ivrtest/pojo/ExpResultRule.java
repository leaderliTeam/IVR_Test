package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("result_and_rule")
public class ExpResultRule {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "test_case_id")
    private String testCaseId;
    @TableField(value = "order_id")
    private String orderId;
    @TableField(value = "rule_type")
    private String ruleType;
    @TableField(value = "rule_value")
    private String ruleValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
