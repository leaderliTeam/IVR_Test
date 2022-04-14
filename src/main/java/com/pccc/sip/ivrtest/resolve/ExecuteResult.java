package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.core.ResolveItem;
import com.pccc.sip.ivrtest.resolve.resolver.Resolver;
import com.pccc.sip.ivrtest.util.GsonUtil;

import java.util.List;

public class ExecuteResult {

    private List<ExecItem> execResult;

    public ExecuteResult(String execResult) {
        this.execResult = GsonUtil.GsonToList(execResult, ExecItem.class);
    }

    private ResolveResult match(ResolveResult resolveResult, ResolveItem item) {
        List<Resolver> resolverList = item.getResolverList();

        ExecItem currentItem = execResult.get(0);

        for (ExecItem execItem : execResult) {
            for (Resolver resolver : resolverList) {
                resolver.resolve(execItem);
            }
        }

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
