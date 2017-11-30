package com.vm.dao.po;

import com.vm.common.bo.ByteConstantVar;

/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>
 * <br/>
 * <br/>
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/24 10:16
 */
public class BasePo {
    /**
     * 主键自增id
     */
    protected Long id;
    /**
     * 创建时间，unixtimestamp
     */
    protected Integer createTime;
    /**
     * 更新时间,unixtimestamp
     */
    protected Integer updateTime;
    /**
     * 是否被删除
     */
    protected Byte status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 对象状态
     */
    public enum Status{
        NORMAL(ByteConstantVar.ONE,"正常"),
        FORAZEN(ByteConstantVar.TWO, "冻结"),
        DELETED(ByteConstantVar.THREE, "删除");

        Status(Byte code, String name) {
            this.code = code;
            this.name = name;
        }

        Byte code;
        String name;

        public Byte getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
