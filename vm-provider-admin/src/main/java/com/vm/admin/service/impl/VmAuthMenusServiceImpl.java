package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAuthMenus;
import com.vm.admin.service.dto.VmAuthMenusDto;
import com.vm.admin.service.inf.VmAuthMenusService;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.dao.util.BasePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAuthMenusServiceImpl implements VmAuthMenusService{
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;
    @Autowired
    VmAdminsLoginLogsMapper vmAdminsLoginLogsMapper;
    @Autowired
    VmAuthMenusMapper vmAuthMenusMapper;
    @Autowired
    CustomVmRolesMenusRealationMapper customVmRolesMenusRealationMapper;
    @Autowired
    VmAuthsMapper vmAuthsMapper;
    @Autowired
    CustomVmRolesAuthsRealationMapper customVmRolesAuthsRealationMapper;
    @Autowired
    VmAdminsRolesRealationMapper vmAdminsRolesRealationMapper;
    @Autowired
    CustomVmRolesMapper customVmRolesMapper;
    @Autowired
    CustomVmAuthMenusMapper customVmAuthMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;
    @Autowired
    VmRolesService vmRolesService;

    @Override
    public List<VmAuthMenusDto> getAdminMenusByRoleIds(List<Long> roleIds) {
        List<Long> menuIds = customVmRolesMenusRealationMapper.getMenuIdsByRoleIds(ImmutableMap.of(
                "roleIds", roleIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        List<VmAuthMenus> vmAuthMenus = customVmAuthMenusMapper.getMenusByIds(ImmutableMap.of(
                "menuIds", menuIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        return makeVmAuthMenusDtos(vmAuthMenus);
    }



    @Override
    public List<VmAuthMenusDto> getAdminMenusByAdminId(Long adminId) {
        List<Long> roleIds = vmRolesService.getRoleIdsByAdminId(adminId);
        return this.getAdminMenusByRoleIds(roleIds);
    }

    private List<VmAuthMenusDto> makeVmAuthMenusDtos(List<VmAuthMenus> vmAuthMenus) {

        return null;
    }
}
