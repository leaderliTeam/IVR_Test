package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.resolver.Resolver;
import com.pccc.sip.ivrtest.resolve.resolver.ResolverFactory;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ResolveAction {

    private static ResolverFactory factory = new ResolverFactory();

    public ResolveChain resolveRule(String ruleJson) {
        List<Rule> list = GsonUtil.GsonToBean(ruleJson, List.class);

        ResolveChain resolveChain = new ResolveChain();

        for (Rule rule : list) {
            String input = rule.getInput();
            String output = rule.getOutput();

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

}
