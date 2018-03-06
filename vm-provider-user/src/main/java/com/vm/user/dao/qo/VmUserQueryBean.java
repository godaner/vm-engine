package com.vm.user.dao.qo;

import com.vm.base.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/6.
 */
public class VmUserQueryBean extends BaseQueryBean {
    private String usernameQuery;

    public String getUsernameQuery() {
        return usernameQuery;
    }

    public void setUsernameQuery(String usernameQuery) {
        this.usernameQuery = usernameQuery;
    }
}
