package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.core.ResolveItem;

import java.util.List;

public class ExecuteResult {

    private String execResult;

    public ExecuteResult(String execResult) {
        this.execResult = execResult;
    }

    public ResolveResult match(ResolveResult resolveResult, ResolveItem item) {

        return resolveResult;
    }

    public ResolveResult match(ResolveResult resolveResult, List<ResolveItem> items) {
        for (ResolveItem item : items) {
            match(resolveResult, item);
            if (resolveResult.isFail()) {
                break;
            }
        }
        return resolveResult;
    }
}
