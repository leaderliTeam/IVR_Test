package com.pccc.sip.ivrtest.entity;

public class BaseResponse {

    public int code = 0;
    public String msg = "success";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
