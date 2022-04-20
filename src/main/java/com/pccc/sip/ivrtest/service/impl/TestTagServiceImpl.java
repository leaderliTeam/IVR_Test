package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.TestTagMapper;
import com.pccc.sip.ivrtest.pojo.TestTag;
import com.pccc.sip.ivrtest.service.TestTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public int deleteTestTagById(List<String> idList) {
        return testTagMapper.deleteBatchIds(idList);
    }

    @Override
    public TestTag findTestTagById(String id) {
        return testTagMapper.selectById(id);
    }


}
