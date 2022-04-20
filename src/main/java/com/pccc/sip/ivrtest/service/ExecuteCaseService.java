package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;
import com.pccc.sip.ivrtest.entity.request.FillDataRequest;
import com.pccc.sip.ivrtest.entity.request.QueryExecCasePageRequest;
import com.pccc.sip.ivrtest.entity.response.QueryExecCasePageResponse;

import java.util.HashMap;
import java.util.List;

public interface ExecuteCaseService {

    boolean addBatchExecCase(FillDataRequest fillDataRequest);
    int addExecCase(ExecuteCaseEntity executeCaseEntity);
    QueryExecCasePageResponse queryByPage(QueryExecCasePageRequest queryExecCasePageRequest);
    int updateById(ExecuteCaseEntity executeCaseEntity);
    int deleteBatchIds(List<String> idList);
    boolean insertBatchExecCase(List<ExecuteCaseEntity> list,String executeBatchNo, HashMap<String,String> map);
}
