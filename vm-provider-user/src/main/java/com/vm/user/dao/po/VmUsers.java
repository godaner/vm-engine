package com.vm.user.dao.po;

import com.vm.base.util.BasePo;
import com.vm.base.util.ByteConstantVar;

public class VmUsers extends BasePo {

    private String username;

    private String password;

    private Byte sex;

    private Integer birthday;

    private String description;

    private String imgUrl;

    /**
     * 状态
     */
    public enum Sex {
        //性别，1为男，1为女，3未设置
        MEN(ByteConstantVar.ONE, "男"),
        WOMEN(ByteConstantVar.TWO, "女"),
        UNKNOWN(ByteConstantVar.THREE, "未设置");

        Byte code;

        String msg;

        Sex(Byte code, String msg) {
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


    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
        this.description = description == null ? null : description.trim();
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public VmUsers() {
    }
}