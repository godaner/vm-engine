package com.vm.user.dao.qo;

import com.vm.base.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/13.
 */
public class VmUsersLoginLogsQueryBean extends BaseQueryBean {
    private String username;
    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
