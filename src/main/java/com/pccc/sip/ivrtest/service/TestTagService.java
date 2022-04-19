package com.pccc.sip.ivrtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.pojo.TestTag;

public interface TestTagService extends IService<TestTag> {
    int addTestTag(TestTag testTag);

    int updateTestTag(TestTag testTag);

    int deleteTestTagById(Integer id);

    TestTag findTestTagById(Integer id);
}
