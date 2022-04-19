package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class TestTag {
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "test_case_id")
    private String testCaseId;
    @TableField(value = "tag_dic_id")
    private Integer labalDicId;

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

    public Integer getLabalDicId() {
        return labalDicId;
    }

    public void setLabalDicId(Integer labalDicId) {
        this.labalDicId = labalDicId;
    }
}
