package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmRoles;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.dao.util.BasePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmRolesServiceImpl  implements VmRolesService{
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
    @Override
    public List<Long> getRoleIdsByAdminId(Long adminId) {

        List<Long> vmRoleIds = vmAdminsRolesRealationMapper.selectIdList(ImmutableMap.of(
                "adminId", adminId,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        return vmRoleIds;
    }

    @Override
    public List<VmRolesDto> getRolesByAdminId(Long adminId) {

        List<Long> roleIds = this.getRoleIdsByAdminId(adminId);
        List<VmRoles> roles = customVmRolesMapper.getRolesByRoleIds(ImmutableMap.of(
                "roleIds", roleIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        return makeRolesDtos(roles);
    }

    private List<VmRolesDto> makeRolesDtos(List<VmRoles> vmRoles) {
        return null;
    }
}
