package com.pccc.sip.ivrtest.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pccc.sip.ivrtest.pojo.TestCase;

public interface TestCaseService extends IService<TestCase> {
    int addTestCase(TestCase testCase);

    int updateTestCase(TestCase testCase);

    int deleteTestCaseById(String id);

    TestCase findTestCaseById(String id);

    IPage getUserPage(Page page, TestCase testCase);
}
