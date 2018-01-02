package com.vm.dao.mapper;

import com.vm.dao.po.VmUsersLoginLogs;
import com.vm.dao.po.VmUsersLoginLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmUsersLoginLogsMapper {
    long countByExample(VmUsersLoginLogsExample example);

    int deleteByExample(VmUsersLoginLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmUsersLoginLogs record);

    int insertSelective(VmUsersLoginLogs record);

    List<VmUsersLoginLogs> selectByExample(VmUsersLoginLogsExample example);

    VmUsersLoginLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmUsersLoginLogs record, @Param("example") VmUsersLoginLogsExample example);

    int updateByExample(@Param("record") VmUsersLoginLogs record, @Param("example") VmUsersLoginLogsExample example);

    int updateByPrimaryKeySelective(VmUsersLoginLogs record);

    int updateByPrimaryKey(VmUsersLoginLogs record);
}