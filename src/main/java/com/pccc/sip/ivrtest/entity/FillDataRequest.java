package com.pccc.sip.ivrtest.entity;

import java.util.List;

public class FillDataRequest {

    private String executeBatchNo;
    private List<ExecuteCaseEntity> list;

    public String getExecuteBatchNo() {
        return executeBatchNo;
    }

    public void setExecuteBatchNo(String executeBatchNo) {
        this.executeBatchNo = executeBatchNo;
    }

    public List<ExecuteCaseEntity> getList() {
        return list;
    }

    public void setList(List<ExecuteCaseEntity> list) {
        this.list = list;
    }
}
