package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.TestTagMapper;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.pojo.TestTag;
import com.pccc.sip.ivrtest.service.TestTagService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTagServiceImpl extends ServiceImpl<TestTagMapper, TestTag> implements TestTagService {

    @Autowired
    private TestTagMapper testTagMapper;

    @Override
    public int addTestTag(TestTag testTag) {
        return testTagMapper.insert(testTag);
    }

    @Override
    public int updateTestTag(TestTag testTag) {
        return testTagMapper.updateById(testTag);
    }

    @Override
    public int deleteTestTagById(Integer id) {
        return testTagMapper.deleteById(id);
    }

    @Override
    public TestTag findTestTagById(Integer id) {
        return testTagMapper.selectById(id);
    }
}
