package com.pccc.sip.ivrtest.service;

import com.pccc.sip.ivrtest.pojo.ExpResultRule;
import com.pccc.sip.ivrtest.pojo.TestCase;

public interface ExpResultRuleService {
    int addExpResultRule(ExpResultRule expResultRule);

    int updateExpResultRule(ExpResultRule expResultRule);

    int deleteExpResultRuleById(String id);

    ExpResultRule findExpResultRuleById(String id);
}
