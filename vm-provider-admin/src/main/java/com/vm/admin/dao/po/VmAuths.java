package com.vm.admin.dao.po;

import com.vm.dao.util.BasePo;

public class VmAuths extends BasePo {
    private String authName;

    private String authCode;

    private String description;

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}