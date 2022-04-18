package com.pccc.sip.ivrtest.entity;

import com.pccc.sip.ivrtest.constant.Type;

public class BasePageResponse {

    public int code = 0;
    public String msg = "success";
    public int pageSize;
    public int currentPage;
    public int totalPage;
    public int totalCount;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setReturnMsg(Type type){
        this.code = Integer.parseInt(type.getType());
        this.msg = type.getTypeName();
    }
}
