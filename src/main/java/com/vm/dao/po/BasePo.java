package com.vm.dao.po;

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
    Long id;
    /**
     * 创建时间，unixtimestamp
     */
    Integer createTime;
    /**
     * 更新时间,unixtimestamp
     */
    Integer updateTime;
    /**
     * 是否被删除
     */
    Integer isDeleted;

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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public enum DeleteStatus{
        NO(1,"未删除"),YES(2, "已经删除");

        DeleteStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        int code;
        String name;

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
