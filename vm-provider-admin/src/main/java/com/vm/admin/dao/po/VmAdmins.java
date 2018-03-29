package com.vm.admin.dao.po;

import com.vm.dao.util.BasePo;

public class VmAdmins extends BasePo {
    private String username;

    private String password;

    private Byte immutable;

    private String description;

    public Byte getImmutable() {
        return immutable;
    }

    public void setImmutable(Byte immutable) {
        this.immutable = immutable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}