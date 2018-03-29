package com.vm.admin.dao.mapper.custom;

import com.google.common.collect.ImmutableMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public interface CustomVmAdminsRolesRealationMapper {
    List<Long> getRoleIdsByAdminId(@Param("query") Object query);

    List<Long> getAdminIdsByRoleId(@Param("query") Object query);

    List<Long> getRealationIdsByAdminIds(@Param("query") Object query);
}
