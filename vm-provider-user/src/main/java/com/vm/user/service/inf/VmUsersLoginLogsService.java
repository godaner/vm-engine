package com.vm.user.service.inf;

import com.vm.base.util.PageBean;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import com.vm.user.service.dto.VmUsersLoginLogsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/13.
 */
public interface VmUsersLoginLogsService {
    List<VmUsersLoginLogsDto> getUserLoginLogs(VmUsersLoginLogsQueryBean query, PageBean page);

    Long getUserLoginLogsTotal(VmUsersLoginLogsQueryBean query, PageBean page);
}
