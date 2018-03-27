package com.vm.admin.dao.qo;

import com.vm.dao.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public class VmAdminLoginLogsQueryBean extends BaseQueryBean{
    private Long adminId;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
