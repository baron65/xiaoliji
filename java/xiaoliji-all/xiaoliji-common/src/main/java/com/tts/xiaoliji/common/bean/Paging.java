package com.tts.xiaoliji.common.bean;

public class Paging {

    private int offset = 0;
    private int limit = 1000;

    public Paging() {
    }

    public Paging(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public Paging initByCurrentPage(int currentPage, int pageCount) {
        if (pageCount > 0) {
            this.limit = pageCount;
        }
        if (currentPage > 0 && pageCount >= 0) {
            this.offset = (currentPage - 1) * pageCount;
        }
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
