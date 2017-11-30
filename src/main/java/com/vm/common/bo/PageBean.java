package com.vm.common.bo;

import com.alibaba.fastjson.JSONObject;


public class PageBean {
    Integer start;
    Integer size;
    String orderBy;
    String orderType;
    String keyword;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public static void main(String[] args) {
        PageBean pageBean = new PageBean();
        pageBean.setStart(0);
        pageBean.setSize(10);
        pageBean.setOrderBy("create_time");
        pageBean.setOrderType("DESC");
        System.out.println(JSONObject.toJSONString(pageBean));
    }
}
