package com.vm.admin.dao.po;

import com.vm.dao.util.BasePo;

public class VmAdminsRolesRealation extends BasePo {
    private Long roleId;

    private Long adminId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}