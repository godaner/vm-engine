package com.vm.dao.po;

import com.vm.base.bo.ByteConstantVar;

/**
 * Created by ZhangKe on 2017/11/30.
 */
public class Users extends BasePo{
    private String username;
    private String password;
    private Byte sex;
    private Integer birthday;
    private String description;

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                "} " + super.toString();
    }

    public Users() {
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users(String username, String password, Byte sex, Integer birthday, String description) {

        this.username = username;
        this.password = password;
        this.sex = sex;
        this.birthday = birthday;
        this.description = description;
    }

    /**
     * 性别
     */
    public enum Sex {
        F(ByteConstantVar.ONE,"男"),
        M(ByteConstantVar.TWO,"女"),
        U(ByteConstantVar.THREE,"未知");
        private Byte code;
        private String msg;

        Sex(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "ErrorCode{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    "} " + super.toString();
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

        Sex() {

        }
    }


}
