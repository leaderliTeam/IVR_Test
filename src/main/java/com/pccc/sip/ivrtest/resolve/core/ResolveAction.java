package com.pccc.sip.ivrtest.resolve.core;

import com.pccc.sip.ivrtest.resolve.Result;
import com.pccc.sip.ivrtest.resolve.Rule;
import com.pccc.sip.ivrtest.resolve.resolver.Resolver;
import com.pccc.sip.ivrtest.resolve.resolver.ResolverFactory;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ResolveAction {

    private String regex = "\\$\\{(.*?)\\}";

    private static ResolverFactory factory = new ResolverFactory();

    public Result resolveResult(Object obj, ResolveChain chain) {

        return null;
    }

    public ResolveChain resolveRule(String ruleJson, Map<String, String> params) {
        List<Rule> list = GsonUtil.GsonToBean(ruleJson, List.class);

        ResolveChain resolveChain = new ResolveChain();

        for (Rule rule : list) {
            String input = rule.getInput();
            String output = rule.getOutput();
            input = replaceKeys(input, params);
            output = replaceKeys(output, params);

            ResolveItem resolveItem = new ResolveItem();
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

    private List<String> getKeys(String targetStr) {
        List<String> keys = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetStr);
        while (matcher.find()) {
            keys.add(matcher.group(1));
        }

        return keys;
    }

    private String replaceKeys(String targetStr, Map<String, String> params) {
        List<String> keys = getKeys(targetStr);

        for (String key : keys) {
            String placeholder = "${" + key + "}";
            String value = params.get(key);
            targetStr = StringUtils.replace(targetStr, placeholder, value);
        }

        return targetStr;
    }

}
