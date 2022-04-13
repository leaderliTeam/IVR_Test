package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {
    @Autowired
    private TestCaseMapper testCaseMapper;

    //增
    @Override
    public int addTestCase(TestCase testCase) {
        return testCaseMapper.insert(testCase);
    }

    //改
    @Override
    public int updateTestCase(TestCase testCase) {
        return testCaseMapper.updateById(testCase);
    }

    //删
    @Override
    public int deleteTestCaseById(String id) {
        return testCaseMapper.deleteById(id);
    }

    //查
    @Override
    public TestCase findTestCaseById(String id) {
        return testCaseMapper.selectById(id);
    }

    @Override
    public IPage getUserPage(Page page, TestCase testCase) {
        return null;
    }
}
