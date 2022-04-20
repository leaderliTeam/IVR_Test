package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.TestCaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseServiceImpl extends ServiceImpl<TestCaseMapper, TestCase> implements TestCaseService {
    @Autowired
    private TestCaseMapper testCaseMapper;
    @Autowired
    private CommonService commonService;

    //增
    @Override
    public int addTestCase(TestCase testCase) {
        String id = commonService.creatTestCaseId();
        testCase.setId(id);
        return testCaseMapper.insert(testCase);
    }

    //改
    @Override
    public int updateTestCase(TestCase testCase) {
        return testCaseMapper.updateById(testCase);
    }

    //删
    @Override
    public int deleteTestCaseById(List<String> idList) {
        return testCaseMapper.deleteBatchIds(idList);
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

    //根据ID查树
    public List<TestCase> getTestCasesById(String id){
        //查顶级
        String topId = getTopId(id);
        return getAllTestCases(topId);
    }

    private String getTopId(String id){

        //当前ID查父级
        TestCase testCase = testCaseMapper.selectOne(new QueryWrapper<TestCase>());
        if (StringUtils.isNotBlank(testCase.getFrontCaseId())){
            return getTopId(testCase.getFrontCaseId());
        }
        return testCase.getId();
    }

    //ID送空，查询所有树
    public List<TestCase> getAllTestCases(String id){
        //查顶级
        List<TestCase> testCases = testCaseMapper.selectList(new QueryWrapper<TestCase>());
        //查孩子
        getChildren(testCases);
        return testCases;
    }

    private void getChildren(List<TestCase> childTestCases){
        for (TestCase testCase:childTestCases){
            String parentId = testCase.getId();
            List<TestCase> children= testCaseMapper.selectList(new QueryWrapper<TestCase>());
            if (children!=null && children.size()>0){
                testCase.setChildren(children);
                getChildren(children);
            }
        }
    }


}
