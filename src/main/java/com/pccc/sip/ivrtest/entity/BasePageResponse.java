package com.pccc.sip.ivrtest.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class BasePageResponse extends BaseResponse{

    public int pageSize;
    public int currentPage;
    public int totalPage;
    public int totalCount;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageInfo(Page page){
        this.pageSize = (int) page.getSize();
        this.currentPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
        this.totalCount= (int) page.getTotal();
    }
}
