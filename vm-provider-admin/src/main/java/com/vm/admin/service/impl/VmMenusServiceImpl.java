package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmMenus;
import com.vm.admin.service.dto.VmMenusDto;
import com.vm.admin.service.inf.VmMenusService;
import com.vm.base.util.BaseService;
import com.vm.base.util.MenuCacheManager;
import com.vm.base.util.SessionCacheManager;
import com.vm.dao.util.BasePo;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmMenusServiceImpl extends BaseService implements VmMenusService {
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;
    @Autowired
    VmAdminsLoginLogsMapper vmAdminsLoginLogsMapper;
    @Autowired
    VmMenusMapper vmMenusMapper;
    @Autowired
    CustomVmRolesMenusRealationMapper customVmRolesMenusRealationMapper;
    @Autowired
    VmAuthsMapper vmAuthsMapper;
    @Autowired
    CustomVmRolesAuthsRealationMapper customVmRolesAuthsRealationMapper;
    @Autowired
    CustomVmAdminsRolesRealationMapper customVmAdminsRolesRealationMapper;
    @Autowired
    VmAdminsRolesRealationMapper vmAdminsRolesRealationMapper;
    @Autowired
    VmRolesMenusRealationMapper vmRolesMenusRealationMapper;
    @Autowired
    CustomVmRolesMapper customVmRolesMapper;
    @Autowired
    CustomVmMenusMapper customVmMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;


    @Override
    public List<VmMenusDto> getUseableMenusTreeByAdminId(Long adminId) {


        List<Long> roleIds = customVmAdminsRolesRealationMapper.getRoleIdsByAdminId(ImmutableMap.of(
                "adminId", adminId,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        if (isEmptyList(roleIds)) {
            return Lists.newArrayList();
        }
        List<Long> menuIds = customVmRolesMenusRealationMapper.getMenuIdsByRoleIds(ImmutableMap.of(
                "roleIds", roleIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));
        if (isEmptyList(menuIds)) {
            return Lists.newArrayList();
        }
        List<VmMenus> menus = vmMenusMapper.selectByAndInIds(menuIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));

        return makeTreeMenusDtos(menus);
    }

    @Override
    public List<VmMenusDto> getMenusTreeByAdminId(Long adminId) {
        String token = SessionCacheManager.getOnlineUserToken(adminId);
        if(isEmptyString(token)){
            return Lists.newArrayList();
        }
        return MenuCacheManager.getMenuTree(token);
    }

    @Override
    public List<VmMenusDto> getAllMenusTree(VmMenusDto vmMenusDto) {
        return makeTreeMenusDtos(vmMenusMapper.selectBy(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )));
    }


    @Override
    public List<Long> getLeafMenuIdsByRoleId(Long roleId) {
        List<Long> menuIds = customVmRolesMenusRealationMapper.getLeafMenuIdsByRoleId(ImmutableMap.of(
                "roleId", roleId,
                "isLeaf", VmMenus.IsLeaf.YES.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
        return menuIds;
    }

    //二级树
    private List<VmMenusDto> makeTreeMenusDtos(List<VmMenus> vmAuthMenus) {
        List<VmMenusDto> root = Lists.newArrayList();

        int i = 0;
        while (i < vmAuthMenus.size()) {
            VmMenus node = vmAuthMenus.get(i);
            if (isNullObject(node.getPid())) {
                VmMenusDto nodeDto = makeVmAuthMenusDto(node);
                root.add(nodeDto);
            }
            i++;
        }
        i = 0;
        while (i < vmAuthMenus.size()) {
            VmMenus node = vmAuthMenus.get(i);
            if (!isNullObject(node.getPid())) {
                for (VmMenusDto r : root) {
                    if (r.getId().equals(node.getPid())) {
                        if (isEmptyList(r.getChild())) {
                            r.setChild(Lists.newArrayList());
                        }
                        VmMenusDto nodeDto = makeVmAuthMenusDto(node);
                        r.getChild().add(nodeDto);
                    }
                }
            }
            i++;
        }
        return root;
    }

    private VmMenusDto makeVmAuthMenusDto(VmMenus vmAuthMenus) {
        VmMenusDto vmAuthMenusDto = new VmMenusDto();
        vmAuthMenusDto.setId(vmAuthMenus.getId());
        vmAuthMenusDto.setDescription(vmAuthMenus.getDescription());
        vmAuthMenusDto.setIsLeaf(vmAuthMenus.getIsLeaf());
        vmAuthMenusDto.setMenuName(vmAuthMenus.getMenuName());
        vmAuthMenusDto.setKeyProp(vmAuthMenus.getKeyProp());
        vmAuthMenusDto.setIcon(vmAuthMenus.getIcon());
        vmAuthMenusDto.setPid(vmAuthMenus.getPid());
        vmAuthMenusDto.setStatus(vmAuthMenus.getStatus());
        vmAuthMenusDto.setCreateTime(vmAuthMenus.getCreateTime());
        vmAuthMenusDto.setUpdateTime(vmAuthMenus.getUpdateTime());
        return vmAuthMenusDto;
    }
}
