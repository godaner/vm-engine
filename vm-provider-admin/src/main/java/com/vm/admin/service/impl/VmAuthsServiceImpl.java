package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAuths;
import com.vm.admin.dao.po.VmRoles;
import com.vm.admin.service.dto.VmAuthsDto;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.dao.util.BasePo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmAuthsServiceImpl implements VmAuthsService {
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
    public List<VmAuthsDto> getAdminAuthsByRoleIds(List<Long> roleIds) {

        List<Long> authIds = customVmRolesAuthsRealationMapper.getAuthIdsByRoleIds(ImmutableMap.of(
                "roleIds", roleIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        List<VmAuths> vmAuths = customVmAuthsMapper.getAuthsByIds(ImmutableMap.of(
                "authIds", authIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));

        return makeVmAuthsDtos(vmAuths);
    }

    @Override
    public List<VmAuthsDto> getAdminAuthsByAdminId(Long adminId) {
        List<Long> roleIds = vmRolesService.getRoleIdsByAdminId(adminId);

        return this.getAdminAuthsByRoleIds(roleIds);
    }

    private List<VmAuthsDto> makeVmAuthsDtos(List<VmAuths> vmAuths) {
        return null;

    }
}
