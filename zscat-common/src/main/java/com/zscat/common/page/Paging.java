//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zscat.common.page;

public class Paging {
    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer totalPage = 0;
    private Integer total = 0;

    public Paging() {
    }

    public Paging(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
        this.totalPage = total == 0 ? 0 : (total % this.pageSize == 0 ? total / this.pageSize : total / this.pageSize + 1);
    }
}
