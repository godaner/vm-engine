package com.vm.dao.po;


import com.vm.dao.validator.group.VmUsersGroups;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import com.vm.base.utils.ByteConstantVar;
import com.vm.base.utils.VmProperties;

import javax.validation.constraints.NotNull;

/**
 * Created by ZhangKe on 2017/12/28.
 */
@ApiModel(value = "用户对象")
public class CustomVmUsers extends BasePo {

    //注册用户时填入的默认img_url前缀
    public static final String USER_IMG_URL_PREFIX = VmProperties.VM_USER_IMG_URL_PREFIX;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "{CustomVmUsers.id.NotNull}", groups = {VmUsersGroups.UpdateUserBasicInfo.class})
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "{CustomVmUsers.username.NotBlank}", groups = {VmUsersGroups.UserLogin.class, VmUsersGroups.UserRegist.class})
    private String username;

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "{CustomVmUsers.password.NotBlank}", groups = {VmUsersGroups.UserLogin.class, VmUsersGroups.UserRegist.class})
    private String password;

    @ApiModelProperty(value = "用户性别")
    private Byte sex;

    @ApiModelProperty(value = "用户生日")
    private Integer birthday;

    @ApiModelProperty(value = "用户描述")
    private String description;

    @ApiModelProperty(value = "用户状态")
    private Byte status;

    @ApiModelProperty(value = "用户创建时间")
    private Integer createTime;

    @ApiModelProperty(value = "用户更新时间")
    private Integer updateTime;

    @ApiModelProperty(value = "用户头像url")
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

    @Override
    public String toString() {
        return "CustomVmUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "} " + super.toString();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
