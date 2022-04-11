package com.pccc.sip.ivrtest.resolve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExecutionResultResolver {

    @Autowired
    private ResolveAction resolveAction;

    public Result resolve(Object obj, String ruleJson, Map<String, String> params) {
        // 获取解析器
        ResolveChain resolveChain = resolveAction.resolveRule(ruleJson, params);

        // 对执行结果进行解析
        Result result = resolveAction.resolveResult(obj, resolveChain);

        return result;
    }

}
