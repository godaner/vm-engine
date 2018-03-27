package com.vm.admin.service.dto;

import com.vm.base.service.dto.BaseDto;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmRolesDto extends BaseDto {
    private String roleName;

    private String description;

    private Byte immutable;

    private String authIds;

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getImmutable() {
        return immutable;
    }

    public void setImmutable(Byte immutable) {
        this.immutable = immutable;
    }
}
