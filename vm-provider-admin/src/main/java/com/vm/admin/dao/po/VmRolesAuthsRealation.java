package com.vm.admin.dao.po;

import com.vm.dao.util.BasePo;

public class VmRolesAuthsRealation extends BasePo {
    private Long roleId;

    private Long authId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}