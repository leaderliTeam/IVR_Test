package com.pccc.sip.ivrtest.resolve;

import java.util.ArrayList;
import java.util.List;

public class ResolveChain {

    private List<ResolveItem> list = new ArrayList<>();

    public void add(ResolveItem resolveItem) {
        list.add(resolveItem);
    }
}
