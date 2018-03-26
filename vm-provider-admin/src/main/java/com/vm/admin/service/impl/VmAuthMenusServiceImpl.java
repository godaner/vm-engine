package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAuthMenus;
import com.vm.admin.service.dto.VmAuthMenusDto;
import com.vm.admin.service.inf.VmAuthMenusService;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.base.util.BaseService;
import com.vm.dao.util.BasePo;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAuthMenusServiceImpl extends BaseService implements VmAuthMenusService {
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

        return makeTreeVmAuthMenusDtos(vmAuthMenus);
    }


    @Override
    public List<VmAuthMenusDto> getAdminMenusByAdminId(Long adminId) {
        List<Long> roleIds = vmRolesService.getRoleIdsByAdminId(adminId);
        return this.getAdminMenusByRoleIds(roleIds);
    }

    //二级树
    private List<VmAuthMenusDto> makeTreeVmAuthMenusDtos(List<VmAuthMenus> vmAuthMenus) {
        List<VmAuthMenusDto> root = Lists.newArrayList();

        int i = 0;
        while (i < vmAuthMenus.size()) {
            VmAuthMenus node = vmAuthMenus.get(i);
            if (isNullObject(node.getPid())) {
                VmAuthMenusDto nodeDto = makeVmAuthMenusDto(node);
                root.add(nodeDto);
            }
            i++;
        }
        i = 0;
        while (i < vmAuthMenus.size()) {
            VmAuthMenus node = vmAuthMenus.get(i);
            if (!isNullObject(node.getPid())) {
                for (VmAuthMenusDto r : root) {
                    if (r.getId().equals(node.getPid())) {
                        if (isEmptyList(r.getChild())) {
                            r.setChild(Lists.newArrayList());
                        }
                        VmAuthMenusDto nodeDto = makeVmAuthMenusDto(node);
                        r.getChild().add(nodeDto);
                    }
                }
            }
            i++;
        }
        return root;
    }

    private VmAuthMenusDto makeVmAuthMenusDto(VmAuthMenus vmAuthMenus) {
        VmAuthMenusDto vmAuthMenusDto = new VmAuthMenusDto();
        vmAuthMenusDto.setId(vmAuthMenus.getId());
        vmAuthMenusDto.setDescription(vmAuthMenus.getDescription());
        vmAuthMenusDto.setIsLeaf(vmAuthMenus.getIsLeaf());
        vmAuthMenusDto.setMenuName(vmAuthMenus.getMenuName());
        vmAuthMenusDto.setPath(vmAuthMenus.getPath());
        vmAuthMenusDto.setPid(vmAuthMenus.getPid());
        vmAuthMenusDto.setStatus(vmAuthMenus.getStatus());
        vmAuthMenusDto.setCreateTime(vmAuthMenus.getCreateTime());
        vmAuthMenusDto.setUpdateTime(vmAuthMenus.getUpdateTime());
        return vmAuthMenusDto;
    }
}
