package com.vm.admin.service.inf;

import com.vm.admin.service.dto.VmMenusDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmMenusService {
    /*************** status ******************/

    /*************** unStatus ******************/
    List<VmMenusDto> getMenusTreeByAdminId(Long adminId);

    List<VmMenusDto> getAllMenusTree(VmMenusDto vmMenusDto);

    List<Long> getMenuIdsByRoleId(Long roleId);
}
