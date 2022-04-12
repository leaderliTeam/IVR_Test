package com.pccc.sip.ivrtest.resolve.core;

import com.pccc.sip.ivrtest.resolve.ResolveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExecutionResultResolver {

    @Autowired
    private ResolveAction resolveAction;

    public ResolveResult resolve(Object obj, String ruleJson, Map<String, String> params) {

        // 获取解析器
        ResolveChain resolveChain = resolveAction.resolveRule(ruleJson, params);

        // 对执行结果进行解析
        ResolveResult result = resolveAction.resolveExecuteResult(obj, resolveChain);

        return result;

    }

}
