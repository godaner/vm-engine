package com.vm.admin.dao.po;

import com.vm.dao.util.BasePo;

public class VmRoles extends BasePo {
    private String roleName;

    private String description;

    private Byte immutable;
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