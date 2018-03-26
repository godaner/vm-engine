package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmAuthMenusDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmAuthMenusService {

    List<VmAuthMenusDto> getAdminMenusByRoleIds(List<Long> roleIds);

    List<VmAuthMenusDto> getAdminMenusByAdminId(Long adminId);
}
