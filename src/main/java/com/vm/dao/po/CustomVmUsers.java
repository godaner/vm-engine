package com.vm.dao.po;

import com.vm.validator.group.VmUsersGroups;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by ZhangKe on 2017/12/28.
 */
public class CustomVmUsers extends BasePo{
    @NotNull(message = "{CustomVmUsers.id.NotNull}",groups = {VmUsersGroups.UpdateUserBasicInfo.class})
    private Long id;

    @NotBlank(message = "{CustomVmUsers.username.NotBlank}",groups = {VmUsersGroups.UserLogin.class})
    private String username;

    @NotBlank(message = "{CustomVmUsers.password.NotBlank}",groups = {VmUsersGroups.UserLogin.class})
    private String password;

    private Boolean sex;

    private Integer birthday;

    private String description;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
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
