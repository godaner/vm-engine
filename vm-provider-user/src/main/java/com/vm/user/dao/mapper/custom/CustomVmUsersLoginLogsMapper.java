package com.vm.user.dao.mapper.custom;

import com.vm.base.util.PageBean;
import com.vm.user.dao.po.VmUsersLoginLogs;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import com.vm.user.service.dto.VmUsersLoginLogsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmUsersLoginLogsMapper {

    List<VmUsersLoginLogsDto> getUserLoginLogs(@Param("query") VmUsersLoginLogsQueryBean query, @Param("page") PageBean page);

    Long getUserLoginLogsTotal(@Param("query") VmUsersLoginLogsQueryBean query, @Param("page") PageBean page);
}