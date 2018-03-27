package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmRoles;
import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmRolesServiceImpl implements VmRolesService {
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;
    @Autowired
    VmAdminsLoginLogsMapper vmAdminsLoginLogsMapper;
    @Autowired
    VmMenusMapper vmAuthMenusMapper;
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
    CustomVmMenusMapper customVmAuthMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;
    @Autowired
    VmRolesMapper vmRolesMapper;

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
        List<VmRoles> roles = vmRolesMapper.selectByAndInIds(roleIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
                )
        );
        return makeRolesDtos(roles);
    }

    @Override
    public List<VmRolesDto> getRoles(PageBean page, VmRolesQueryBean query) {
        List<VmRoles> vmRoles = vmRolesMapper.selectPageList(page, query);
        return makeRolesDtos(vmRoles);
    }

    @Override
    public Long getRolesTotal(PageBean page, VmRolesQueryBean query) {
        return null;
    }

    private List<VmRolesDto> makeRolesDtos(List<VmRoles> vmRoles) {
        return vmRoles.stream().parallel().map(r -> {
            return makeRolesDto(r);
        }).collect(toList());
    }

    private VmRolesDto makeRolesDto(VmRoles vmRoles) {
        VmRolesDto vmRolesDto = new VmRolesDto();
        vmRolesDto.setDescription(vmRoles.getDescription());
        vmRolesDto.setImmutable(vmRoles.getImmutable());
        vmRolesDto.setRoleName(vmRoles.getRoleName());
        vmRolesDto.setCreateTime(vmRoles.getCreateTime());
        vmRolesDto.setUpdateTime(vmRoles.getUpdateTime());
        vmRolesDto.setStatus(vmRoles.getStatus());
        return vmRolesDto;
    }
}
