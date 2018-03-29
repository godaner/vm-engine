package com.vm.admin.dao.qo;

import com.vm.dao.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmAdminsQueryBean extends BaseQueryBean{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
