package com.vm.user.dao.po.custom;

import com.vm.user.dao.po.VmUsersLoginLogs;

/**
 * Created by ZhangKe on 2018/3/13.
 */
public class CustomVmUsersLoginLogs extends VmUsersLoginLogs {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
