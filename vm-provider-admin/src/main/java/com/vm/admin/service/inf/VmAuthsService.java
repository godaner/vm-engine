package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmAuthsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmAuthsService {

    List<VmAuthsDto> getAdminAuthsByRoleIds(List<Long> roleIds);

    List<VmAuthsDto> getAdminAuthsByAdminId(Long adminId);
}
