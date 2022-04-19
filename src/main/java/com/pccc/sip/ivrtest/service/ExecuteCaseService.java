package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;
import com.pccc.sip.ivrtest.entity.FillDataRequest;
import com.pccc.sip.ivrtest.entity.QueryExecCasePageRequest;
import com.pccc.sip.ivrtest.entity.QueryExecCasePageResponse;

import java.util.List;

public interface ExecuteCaseService {

    boolean addBatchExecCase(FillDataRequest fillDataRequest);
    int addExecCase(ExecuteCaseEntity executeCaseEntity);
    QueryExecCasePageResponse queryByPage(QueryExecCasePageRequest queryExecCasePageRequest);
    int updateById(ExecuteCaseEntity executeCaseEntity);
    int deleteBatchIds(List<String> idList);
}
