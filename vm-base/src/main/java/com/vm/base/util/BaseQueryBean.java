package com.vm.base.util;


/**
 * Created by ZhangKe on 2018/3/1.
 */
public class BaseQueryBean {
    private String keyword;
    private Byte isDeleted = BasePo.IsDeleted.NO.getCode();
    private Byte status = BasePo.Status.NORMAL.getCode();

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
