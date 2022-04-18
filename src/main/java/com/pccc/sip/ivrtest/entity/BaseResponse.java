package com.pccc.sip.ivrtest.entity;

import com.pccc.sip.ivrtest.constant.Type;

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

    public void setReturnMsg(Type type){
        this.code = Integer.parseInt(type.getType());
        this.msg = type.getTypeName();
    }
}
