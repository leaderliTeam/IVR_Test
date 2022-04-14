package com.pccc.sip.ivrtest.resolve.core;

import com.pccc.sip.ivrtest.resolve.resolver.Resolver;

import java.util.ArrayList;
import java.util.List;

public class ResolveItem {

    private String input;

    List<Resolver> resolverList = new ArrayList<>();

    private String rule;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void add(Resolver resolver) {
        resolverList.add(resolver);
    }

    public List<Resolver> getResolverList() {
        return resolverList;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
