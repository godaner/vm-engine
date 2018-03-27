package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAuths;
import com.vm.admin.service.dto.VmAuthsDto;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.dao.util.BasePo;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAuthsServiceImpl implements VmAuthsService {
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
    CustomVmMenusMapper customVmMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;
    @Autowired
    VmRolesService vmRolesService;

    @Override
    public List<VmAuthsDto> getAuthsByRoleIds(List<Long> roleIds) {

        List<Long> authIds = this.getAuthIdsByRoleIds(roleIds);

        List<VmAuths> vmAuths = vmAuthsMapper.selectByAndInIds(authIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));

        return makeVmAuthsDtos(vmAuths);
    }

    private List<Long> getAuthIdsByRoleIds(List<Long> roleIds) {
        return customVmRolesAuthsRealationMapper.getAuthIdsByRoleIds(ImmutableMap.of(
                "roleIds", roleIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
    }

    @Override
    public List<VmAuthsDto> getAuthsByAdminId(Long adminId) {
        List<Long> roleIds = vmRolesService.getRoleIdsByAdminId(adminId);

        return this.getAuthsByRoleIds(roleIds);
    }

    @Override
    public List<String> getAuthCodesByAdminId(Long adminId) {

        List<Long> roleIds = vmRolesService.getRoleIdsByAdminId(adminId);

        List<Long> authIds = this.getAuthIdsByRoleIds(roleIds);


        return customVmAuthsMapper.getAuthCodesByAuthIds(ImmutableMap.of(
                "authIds", authIds,
                "status", BasePo.Status.NORMAL.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
    }

    @Override
    public List<VmAuthsDto> getAllAuths() {
        return makeVmAuthsDtos(vmAuthsMapper.selectBy(ImmutableMap.of(
                "status", BasePo.Status.NORMAL.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )));
    }

    @Override
    public List<Long> getAuthIdsByRoleId(Long roleId) {

        return customVmRolesAuthsRealationMapper.getAuthIdsByRoleIds(ImmutableMap.of(
                "roleIds", Lists.newArrayList(roleId),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));

    }

    private List<VmAuthsDto> makeVmAuthsDtos(List<VmAuths> vmAuths) {
        return vmAuths.stream().parallel().map(auth -> {
            return makeVmAuthsDto(auth);
        }).collect(toList());

    }

    private VmAuthsDto makeVmAuthsDto(VmAuths auth) {
        VmAuthsDto vmAuthsDto = new VmAuthsDto();
        vmAuthsDto.setAuthCode(auth.getAuthCode());
        vmAuthsDto.setId(auth.getId());
        vmAuthsDto.setAuthName(auth.getAuthName());
        vmAuthsDto.setDescription(auth.getDescription());
        vmAuthsDto.setCreateTime(auth.getCreateTime());
        vmAuthsDto.setUpdateTime(auth.getUpdateTime());
        vmAuthsDto.setStatus(auth.getStatus());
        return vmAuthsDto;
    }
}
