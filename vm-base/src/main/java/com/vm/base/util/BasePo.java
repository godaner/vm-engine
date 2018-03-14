package com.vm.base.util;


/**
 * Created by ZhangKe on 2017/12/11.
 */
public class BasePo {

    private Long id;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    private Byte isDeleted;

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    /**
     * 状态
     */
    public enum Status {
        NORMAL(ByteConstantVar.ONE, "正常"),
        FROZEN(ByteConstantVar.TWO, "冻结");

        Byte code;

        String msg;

        Status(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


        /**
         * 是否冻结状态
         *
         * @return
         */
        public static boolean isFrozen(Byte status) {
            if (status.equals(Status.FROZEN.getCode())) {
                return true;
            }
            return false;
        }

        /**
         * 是否正常状态
         *
         * @return
         */
        public static boolean isNormal(Byte status) {
            if (status.equals(Status.NORMAL.getCode())) {
                return true;
            }
            return false;
        }
    }

    /**
     * 是否删除枚举
     */
    public enum IsDeleted {
        NO(ByteConstantVar.ONE, "未删除"),
        YES(ByteConstantVar.TWO, "删除");

        Byte code;

        String msg;

        IsDeleted(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        /**
         * 是否删除状态
         *
         * @return
         */
        public static boolean isDeleted(Byte status) {
            if (status.equals(IsDeleted.YES.getCode())) {
                return true;
            }
            return false;
        }

    }
}
