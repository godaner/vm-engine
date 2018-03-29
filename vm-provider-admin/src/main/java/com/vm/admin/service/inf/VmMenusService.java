package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmMenusDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmMenusService {
    /*************** status ******************/
    List<VmMenusDto> getUseableMenusTreeByAdminId(Long adminId);
    List<VmMenusDto> getMenusTreeByAdminId(Long adminId);

    /*************** unStatus ******************/

    List<VmMenusDto> getAllMenusTree(VmMenusDto vmMenusDto);

    List<Long> getLeafMenuIdsByRoleId(Long roleId);
}
