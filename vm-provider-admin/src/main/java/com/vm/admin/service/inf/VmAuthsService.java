package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmAuthsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmAuthsService {
    /******************** status****************************/

//    List<String> getUseableAuthCodesByAdminId(Long adminId);

    /******************** unStatus****************************/
    List<VmAuthsDto> getAllAuths();

    List<Long> getAuthIdsByRoleId(Long roleId);
}
