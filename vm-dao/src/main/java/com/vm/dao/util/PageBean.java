package com.vm.dao.util;


import com.vm.base.util.CommonUtil;

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

        this.orderBy = CommonUtil.isEmptyString(orderBy) ? "create_time" : orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {

        this.orderType = CommonUtil.isEmptyString(orderType) ? "desc" : orderType;
    }

    public PageBean() {
    }

    public PageBean(Integer start, Integer size, String orderBy, String orderType) {

        this.start = start;
        this.size = size;
        this.orderBy = orderBy;
        this.orderType = orderType;
    }

}
