package com.pccc.sip.ivrtest.pojo;

import com.baomidou.mybatisplus.annotation.TableField;

public class TagDictionary {
    private Integer id;
    @TableField(value = "text_comment")
    private String textDesc;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextDesc() {
        return textDesc;
    }

    public void setTextDesc(String textDesc) {
        this.textDesc = textDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
