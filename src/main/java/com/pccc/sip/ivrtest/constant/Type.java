package com.pccc.sip.ivrtest.constant;

public enum Type {

    EXECCASE("E","执行案例"),
    TESTCASE("T","测试案例");

    private String type;
    private String typeName;

    Type(String type,String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
