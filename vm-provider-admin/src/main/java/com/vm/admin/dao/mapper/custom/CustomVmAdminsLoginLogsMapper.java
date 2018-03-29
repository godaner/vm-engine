package com.vm.admin.dao.mapper.custom;

import com.vm.admin.dao.po.custom.CustomVmAdminsLoginLogs;
import com.vm.admin.dao.qo.VmAdminLoginLogsQueryBean;
import com.vm.dao.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public interface CustomVmAdminsLoginLogsMapper {
    List<CustomVmAdminsLoginLogs> getLoginLogs(@Param("page") PageBean page, @Param("query") VmAdminLoginLogsQueryBean query);

    Long getLoginLogsTotal(@Param("page") PageBean page, @Param("query") VmAdminLoginLogsQueryBean query);

}
