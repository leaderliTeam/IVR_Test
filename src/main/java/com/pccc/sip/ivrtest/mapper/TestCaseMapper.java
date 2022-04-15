package com.pccc.sip.ivrtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pccc.sip.ivrtest.pojo.TestCase;

public interface TestCaseMapper extends BaseMapper<TestCase> {

    int updateTestCaseById(TestCase testCase);
    String queryByLikeId(String id);

}
