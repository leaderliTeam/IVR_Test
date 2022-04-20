package com.pccc.sip.ivrtest.entity.response;

import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;

import java.util.List;

public class QueryExecCasePageResponse extends BasePageResponse{

    private List<ExecuteCaseEntity> list;

    public List<ExecuteCaseEntity> getList() {
        return list;
    }

    public void setList(List<ExecuteCaseEntity> list) {
        this.list = list;
    }
}
