package com.pccc.sip.ivrtest.resolve;

public class ResolveResult {

    private boolean isSuccess = true;

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

    }
}
