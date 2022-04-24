package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.entity.ExecCaseResultEntity;
import com.pccc.sip.ivrtest.entity.request.QueryECResPageRequest;
import com.pccc.sip.ivrtest.entity.response.QueryECResPageResponse;

import java.util.List;

public interface ExecuteCaseResultService {

    QueryECResPageResponse queryByPage(QueryECResPageRequest queryExecCasePageRequest);
    List<ExecCaseResultEntity> queryAllList(String id);

}
