package com.pccc.sip.ivrtest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.pojo.TestTag;

import java.util.List;

public interface TestTagService extends IService<TestTag> {
    int addTestTag(TestTag testTag);

    int updateTestTag(TestTag testTag);

    int deleteTestTagById(List<String> idList);

    TestTag findTestTagById(String id);
}
