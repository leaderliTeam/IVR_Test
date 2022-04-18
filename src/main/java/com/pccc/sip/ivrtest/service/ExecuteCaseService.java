package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;
import com.pccc.sip.ivrtest.entity.FillDataRequest;
import com.pccc.sip.ivrtest.entity.QueryExecCasePageRequest;
import com.pccc.sip.ivrtest.entity.QueryExecCasePageResponse;

public interface ExecuteCaseService {

    public boolean addBatchExecCase(FillDataRequest fillDataRequest);
    public int addExecCase(ExecuteCaseEntity executeCaseEntity);
    public QueryExecCasePageResponse queryByPage(QueryExecCasePageRequest queryExecCasePageRequest);

}
