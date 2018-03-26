package com.vm.admin.dao.mapper.custom;

import com.vm.admin.dao.po.VmRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmRolesMapper {

    List<VmRoles> getRolesByRoleIds(@Param("query") Object query);
}
