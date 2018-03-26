package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmRolesDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmRolesService {
    List<Long> getRoleIdsByAdminId(Long adminId);
    List<VmRolesDto> getRolesByAdminId(Long adminId);
}
