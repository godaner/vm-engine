package com.vm.admin.service.inf;

import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.dao.util.PageBean;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmRolesService {
    List<Long> getRoleIdsByAdminId(Long adminId);

    List<VmRolesDto> getRolesByAdminId(Long adminId);

    List<VmRolesDto> getRoles(PageBean page, VmRolesQueryBean query);

    Long getRolesTotal(PageBean page, VmRolesQueryBean query);

    VmRolesDto addRole(VmRolesDto vmRolesDto);

    VmRolesDto editRole(VmRolesDto vmRolesDto);

}
