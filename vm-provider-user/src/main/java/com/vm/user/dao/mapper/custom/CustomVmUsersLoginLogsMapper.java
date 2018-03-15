package com.vm.user.dao.mapper.custom;

import com.vm.dao.util.PageBean;
import com.vm.user.dao.po.custom.CustomVmUsersLoginLogs;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmUsersLoginLogsMapper {

    List<CustomVmUsersLoginLogs> getUserLoginLogs(@Param("query") VmUsersLoginLogsQueryBean query, @Param("page") PageBean page);

    Long getUserLoginLogsTotal(@Param("query") VmUsersLoginLogsQueryBean query, @Param("page") PageBean page);
}