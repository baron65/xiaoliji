package com.tts.xiaoliji.common.bean;

import java.util.List;

public class PagingData<T> {

    private List<T> list;
    private int totalCount;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
