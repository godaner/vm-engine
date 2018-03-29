package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAuths;
import com.vm.admin.service.dto.VmAuthsDto;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.base.util.BaseService;
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
public class VmAuthsServiceImpl extends BaseService implements VmAuthsService {
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
    CustomVmAdminsRolesRealationMapper customVmAdminsRolesRealationMapper;


    @Override
    public List<String> getUseableAuthCodesByAdminId(Long adminId) {


        List<String> authCodes = null;
        List<Long> roleIds = customVmAdminsRolesRealationMapper.getRoleIdsByAdminId(ImmutableMap.of(
                "adminId", adminId,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()

        ));
        if (!isEmptyList(roleIds)) {
            List<Long> authIds = customVmRolesAuthsRealationMapper.getAuthIdsByRoleIds(ImmutableMap.of(
                    "roleIds", roleIds,
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "status", BasePo.Status.NORMAL.getCode()
            ));
            if (!isEmptyList(authIds)) {
                authCodes = customVmAuthsMapper.getAuthCodesByAuthIds(ImmutableMap.of(
                        "authIds", authIds,
                        "status", BasePo.Status.NORMAL.getCode(),
                        "isDeleted", BasePo.IsDeleted.NO.getCode()
                ));
            }
        }
        if (isNullObject(authCodes)) {
            authCodes = Lists.newArrayList();
        }
        return authCodes;
    }

    @Override
    public List<VmAuthsDto> getAllAuths() {
        return makeVmAuthsDtos(vmAuthsMapper.selectBy(ImmutableMap.of(
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
