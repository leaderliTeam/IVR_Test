package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.core.ResolveItem;

import java.util.List;

public class ExecuteResult {

    private Object obj;

    public ExecuteResult(Object obj) {
        this.obj = obj;
    }

    public ResolveResult match(ResolveItem item) {
        return null;
    }

    public ResolveResult match(List<ResolveItem> items) {
        return null;
    }
}
