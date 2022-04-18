package com.pccc.sip.ivrtest.entity;

import java.util.List;

public class FillDataRequest {

    private String executeBatchNo;
    private List<ExecuteCaseRequest> list;

    public String getExecuteBatchNo() {
        return executeBatchNo;
    }

    public void setExecuteBatchNo(String executeBatchNo) {
        this.executeBatchNo = executeBatchNo;
    }

    public List<ExecuteCaseRequest> getList() {
        return list;
    }

    public void setList(List<ExecuteCaseRequest> list) {
        this.list = list;
    }
}
