package com.vm.admin.service.inf;

import com.vm.admin.dao.qo.VmAdminLoginLogsQueryBean;
import com.vm.admin.service.dto.VmAdminLoginLogsDto;
import com.vm.dao.util.PageBean;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public interface VmAdminLoginLogsService {
    List<VmAdminLoginLogsDto> getLoginLogs(PageBean page, VmAdminLoginLogsQueryBean query);

    Long getLoginLogsTotal(PageBean page, VmAdminLoginLogsQueryBean query);
}
