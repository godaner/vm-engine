package com.vm.admin.dao.po.custom;

import com.vm.admin.dao.po.VmAdminsLoginLogs;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public class CustomVmAdminsLoginLogs extends VmAdminsLoginLogs {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
