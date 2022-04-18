package com.pccc.sip.ivrtest.resolve;

import java.util.ArrayList;
import java.util.List;

public class ResolveResult {

    private boolean isSuccess = true;

    private List<ExecItem> list = new ArrayList<>();

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFail() {
        return !isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void add(ExecItem item) {
        list.add(item);
    }

    public void addAll(List<ExecItem> items) {
        list.addAll(items);
    }

    public ExecItem get(int index) {
        return list.get(index);
    }
}
