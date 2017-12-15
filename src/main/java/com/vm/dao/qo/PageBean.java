package com.vm.dao.qo;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PageBean {
    @Min(value = 0,message="{PageBean.start.min}")
    private Integer start;
    @Min(value = 1,message="{PageBean.size.Min}")
    private Integer size;
    @NotBlank(message="{PageBean.orderBy.NotBlank}")
    private String orderBy;
    @NotBlank(message="{PageBean.orderType.NotBlank}")
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
        this.orderBy = orderBy;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
