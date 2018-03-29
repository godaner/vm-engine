package com.vm.admin.dao.mapper.custom;

import com.google.common.collect.ImmutableMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmRolesMenusRealationMapper {

    List<Long> getMenuIdsByRoleIds(@Param("query") Object query);

    List<Long> getLeafMenuIdsByRoleId(@Param("query") Object query);
}
