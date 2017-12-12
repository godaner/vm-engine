package com.vm.dao.mapper;

import com.vm.dao.po.VmAdminsLoginLogs;
import com.vm.dao.po.VmAdminsLoginLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmAdminsLoginLogsMapper {
    long countByExample(VmAdminsLoginLogsExample example);

    int deleteByExample(VmAdminsLoginLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmAdminsLoginLogs record);

    int insertSelective(VmAdminsLoginLogs record);

    List<VmAdminsLoginLogs> selectByExample(VmAdminsLoginLogsExample example);

    VmAdminsLoginLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmAdminsLoginLogs record, @Param("example") VmAdminsLoginLogsExample example);

    int updateByExample(@Param("record") VmAdminsLoginLogs record, @Param("example") VmAdminsLoginLogsExample example);

    int updateByPrimaryKeySelective(VmAdminsLoginLogs record);

    int updateByPrimaryKey(VmAdminsLoginLogs record);
}