package com.pccc.sip.ivrtest.entity.response;

public class ExecuteCaseResponse extends BaseResponse{

    private String id;
    private int size;

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
