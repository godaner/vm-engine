package com.vm.base.util;


public class PageBean extends CommonUtil {
    private Integer start;
    private Integer size;
    private String orderBy;
    private String orderType;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {

        this.orderBy = isEmptyString(orderBy) ? "create_time" : orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {

        this.orderType = isEmptyString(orderType) ? "desc" : orderType;
    }

    public PageBean() {
    }

    public PageBean(Integer start, Integer size, String orderBy, String orderType) {

        this.start = start;
        this.size = size;
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "start=" + start +
                ", size=" + size +
                ", orderBy='" + orderBy + '\'' +
                ", orderType='" + orderType + '\'' +
                '}';
    }
}
