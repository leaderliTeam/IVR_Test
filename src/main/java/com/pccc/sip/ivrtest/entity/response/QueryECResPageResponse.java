package com.pccc.sip.ivrtest.entity.response;

import com.pccc.sip.ivrtest.entity.ExecCaseResultEntity;

import java.util.List;

public class QueryECResPageResponse extends BasePageResponse{

    private List<ExecCaseResultEntity> list;

    public List<ExecCaseResultEntity> getList() {
        return list;
    }

    public void setList(List<ExecCaseResultEntity> list) {
        this.list = list;
    }
}
