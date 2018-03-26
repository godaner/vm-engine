package com.vm.admin.service.inf;

import com.vm.admin.dao.po.VmAdmins;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.dto.VmAuthMenusDto;
import com.vm.admin.service.dto.VmAuthsDto;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface VmAdminsService {

    List<VmAuthMenusDto> getAdminMenusByRoleIds(List<Long> roleIds);

    List<VmAuthMenusDto> getAdminMenusByAdminId(Long adminId);

    List<VmAuthsDto> getAdminAuthsByRoleIds(List<Long> roleIds);

    List<Long> getRoleIdsByAdminId(Long adminId);

    List<VmAuthsDto> getAdminAuthsByAdminId(Long adminId);

    List<VmRolesDto> getRolesByAdminId(Long adminId);

    List<VmAdminsDto> getAdmins(PageBean page, VmAdminsQueryBean query);

    Long getAdminsTotal(PageBean page, VmAdminsQueryBean query);

    VmAdminsDto addAdmin(VmAdminsDto vmAdminsDto);

    VmAdminsDto editAdmin(VmAdminsDto vmAdminsDto);

    VmAdmins getAdminById(Long userId, BasePo.Status status, BasePo.IsDeleted isDeleted);

    VmAdmins getAdminById(Long userId, BasePo.IsDeleted isDeleted);

    VmAdminsDto adminLogin(VmAdminsDto vmAdminsDto) throws Exception;

    VmAdminsDto getOnlineAdmin(String token);

    void adminLogout(String token);

    VmAdminsDto makeVmAdminDto(VmAdmins vmAdmins, String token, List<VmAuthMenusDto> vmAuthMenusDtos);
}
