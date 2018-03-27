package com.vm.admin.dao.mapper.custom;

import com.vm.admin.dao.po.VmRoles;
import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.dao.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmRolesMapper {

    List<VmRoles> getRoles(@Param("page") PageBean page,@Param("query")  VmRolesQueryBean query);

    Long getRolesTotal(@Param("page") PageBean page,@Param("query")  VmRolesQueryBean query);
}
