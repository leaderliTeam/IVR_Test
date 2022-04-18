package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.core.ResolveItem;
import com.pccc.sip.ivrtest.resolve.resolver.Resolver;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExecuteResult {

    private int index = 0;
    private int inputindex = 0;

    private List<ExecItem> execResult;

    public ExecuteResult(String execResult) {
        this.execResult = GsonUtil.GsonToList(execResult, ExecItem.class);
    }

    private void match(ResolveResult resolveResult, ResolveItem item) {
        String input = item.getInput();

        for (; index < execResult.size(); ) {
            ExecItem execItem = execResult.get(index);
            resolveResult.add(execItem);
            index++;

            if (StringUtils.equals(ExecItem.type_input, execItem.getType())
                    && StringUtils.equals(execItem.getValue(), input)) {
                inputindex = index;
                matchOutput(resolveResult, item.getResolverList());
            }
        }

    }

    private boolean matchOutput(ResolveResult resolveResult, List<Resolver> resolverList) {
        boolean allClear = true;


        out:
        for (Resolver resolver : resolverList) {
            for (; index < execResult.size(); ) {
                ExecItem execItem = execResult.get(index);
                if (StringUtils.equals(ExecItem.type_input, execItem.getType())) {
                    return false;
                }

                resolver.resolve(execItem);

                allClear = resolver.resolve(execItem);
                resolveResult.add(execItem);
            }
        }

        return allClear;
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
