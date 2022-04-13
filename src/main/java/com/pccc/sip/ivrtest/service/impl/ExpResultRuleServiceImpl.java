package com.pccc.sip.ivrtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pccc.sip.ivrtest.mapper.ExpResultRuleMapper;
import com.pccc.sip.ivrtest.pojo.ExpResultRule;
import com.pccc.sip.ivrtest.service.ExpResultRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpResultRuleServiceImpl extends ServiceImpl<ExpResultRuleMapper, ExpResultRule> implements ExpResultRuleService {
    @Autowired
    private ExpResultRuleMapper expResultRuleMapper;

    @Override
    public int addExpResultRule(ExpResultRule expResultRule) {
        return expResultRuleMapper.insert(expResultRule);
    }

    @Override
    public int updateExpResultRule(ExpResultRule expResultRule) {
        return expResultRuleMapper.updateById(expResultRule);
    }

    @Override
    public int deleteExpResultRuleById(String id) {
        return expResultRuleMapper.deleteById(id);
    }

    @Override
    public ExpResultRule findExpResultRuleById(String id) {
        return expResultRuleMapper.selectById(id);
    }
}
