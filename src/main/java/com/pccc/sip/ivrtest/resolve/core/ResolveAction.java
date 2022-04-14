package com.pccc.sip.ivrtest.resolve.core;

import com.pccc.sip.ivrtest.resolve.ExecuteResult;
import com.pccc.sip.ivrtest.resolve.ResolveResult;
import com.pccc.sip.ivrtest.resolve.Rule;
import com.pccc.sip.ivrtest.resolve.resolver.Resolver;
import com.pccc.sip.ivrtest.resolve.resolver.ResolverFactory;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ResolveAction {

    private static ResolverFactory factory = new ResolverFactory();

    public ResolveResult resolveExecuteResult(String execResult, ResolveChain chain) {
        ExecuteResult executeResult = new ExecuteResult(execResult);
        ResolveResult resolveResult = new ResolveResult();

        List<ResolveItem> items = chain.getItems();

        executeResult.match(resolveResult, items);

        return resolveResult;
    }

    public ResolveChain resolveRule(String ruleJson, Map<String, String> params) {
        List<Rule> list = GsonUtil.GsonToList(ruleJson, Rule.class);

        ResolveChain resolveChain = new ResolveChain();

        for (Rule rule : list) {
            String input = rule.getInput();
            String output = rule.getOutput();

            ResolveItem resolveItem = new ResolveItem();
            resolveItem.setRule("input:\"" + input + "\", " + "output:\"" + output + "\"");

            input = replaceKeys(input, params);
            output = replaceKeys(output, params);

            resolveItem.setInput(input);

            String[] value = StringUtils.split(output, ";");
            for (String s : value) {
                Resolver resolver = factory.createResolver(s);
                resolveItem.add(resolver);
            }

            resolveChain.add(resolveItem);
        }

        return resolveChain;
    }

    private String replaceKeys(String targetStr, Map<String, String> params) {
        StringSubstitutor stringSubstitutor = new StringSubstitutor(params);

        String msg = stringSubstitutor.replace(targetStr);

        return msg;
    }

}
