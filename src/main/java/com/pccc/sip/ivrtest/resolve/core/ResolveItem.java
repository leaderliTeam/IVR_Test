package com.pccc.sip.ivrtest.resolve.core;

import com.pccc.sip.ivrtest.resolve.resolver.Resolver;

import java.util.ArrayList;
import java.util.List;

public class ResolveItem {

    private String input;

    List<Resolver> resolverList = new ArrayList<>();

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void add(Resolver resolver) {
        resolverList.add(resolver);
    }
}
