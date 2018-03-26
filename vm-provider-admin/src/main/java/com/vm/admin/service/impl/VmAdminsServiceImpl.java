package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.VmAdminsMapper;
import com.vm.admin.dao.mapper.custom.CustomVmAdminsMapper;
import com.vm.admin.dao.po.VmAdmins;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.exception.VmAdminException;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.base.util.BaseService;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAdminsServiceImpl extends BaseService implements VmAdminsService {
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;

    @Override
    public List<VmAdminsDto> getAdmins(PageBean page, VmAdminsQueryBean query) {
        List<VmAdmins> admins = customVmAdminsMapper.getAdmins(page, query);

        return makeBackendAdminsDtos(admins);
    }

    private List<VmAdminsDto> makeBackendAdminsDtos(List<VmAdmins> admins) {
        return admins.stream().parallel().map(vmAdmins -> {
            return makeBackendAdminsDto(vmAdmins);
        }).collect(toList());
    }

    private VmAdminsDto makeBackendAdminsDto(VmAdmins vmAdmins) {
        VmAdminsDto vmAdminsDto = new VmAdminsDto();
        vmAdminsDto.setCreateTime(vmAdmins.getCreateTime());
        vmAdminsDto.setUpdateTime(vmAdmins.getUpdateTime());
        vmAdminsDto.setId(vmAdmins.getId());
        vmAdminsDto.setDescription(vmAdmins.getDescription());
        vmAdminsDto.setImmutable(vmAdmins.getImmutable());
        vmAdminsDto.setUsername(vmAdmins.getUsername());
        vmAdminsDto.setPassword(vmAdmins.getPassword());
        vmAdminsDto.setStatus(vmAdmins.getStatus());
        return vmAdminsDto;
    }

    @Override
    public Long getAdminsTotal(PageBean page, VmAdminsQueryBean query) {
        return customVmAdminsMapper.getAdminsTotal(page, query);
    }

    @Override
    public VmAdminsDto addAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = vmAdminsMapper.selectOneBy(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "username", vmAdminsDto.getUsername()
        ));
        if (!isNullObject(vmAdmins)) {
            throw new VmAdminException("addAdmin username is exits !! vmAdminsDto is : " + vmAdminsDto,
                    VmAdminException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                    VmAdminException.ErrorCode.USERNAME_IS_EXITS.getMsg());
        }

        vmAdmins = makeAddAdmin(vmAdminsDto);

        if (1 != vmAdminsMapper.insert(vmAdmins)) {
            throw new VmAdminException("addAdmin vmAdminsMapper#insert is fail !! vmAdminsDto is : " + vmAdminsDto);
        }

        vmAdmins = this.getAdminById(vmAdmins.getId(), BasePo.IsDeleted.NO);

        return makeBackendAdminsDto(vmAdmins);
    }


    @Override
    public VmAdminsDto editAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = this.getAdminById(vmAdminsDto.getId(), BasePo.IsDeleted.NO);
        if (!vmAdmins.getUsername().equals(vmAdminsDto.getUsername())) {
            vmAdmins = vmAdminsMapper.selectOneBy(ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "username", vmAdminsDto.getUsername()
            ));
            if (!isNullObject(vmAdmins)) {
                throw new VmAdminException("addAdmin username is exits !! vmAdminsDto is : " + vmAdminsDto,
                        VmAdminException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                        VmAdminException.ErrorCode.USERNAME_IS_EXITS.getMsg());
            }
        }


        vmAdmins = makeEditAdmin(vmAdminsDto);

        if (1 != vmAdminsMapper.update(vmAdminsDto.getId(), vmAdmins)) {
            throw new VmAdminException("addAdmin vmAdminsMapper#update is fail !! vmAdminsDto is : " + vmAdminsDto);
        }

        vmAdmins = this.getAdminById(vmAdmins.getId(), BasePo.IsDeleted.NO);

        return makeBackendAdminsDto(vmAdmins);
    }

    private VmAdmins makeAddAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = new VmAdmins();
        Integer now = now();
        vmAdmins.setDescription(vmAdminsDto.getDescription());
        vmAdmins.setImmutable(vmAdminsDto.getImmutable());
        vmAdmins.setPassword(vmAdminsDto.getPassword());
        vmAdmins.setUsername(vmAdminsDto.getUsername());
        vmAdmins.setStatus(vmAdminsDto.getStatus());
        vmAdmins.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmAdmins.setUpdateTime(now);
        vmAdmins.setCreateTime(now);
        return vmAdmins;
    }

    private VmAdmins makeEditAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = new VmAdmins();
        Integer now = now();
        vmAdmins.setDescription(vmAdminsDto.getDescription());
        vmAdmins.setImmutable(vmAdminsDto.getImmutable());
        vmAdmins.setPassword(vmAdminsDto.getPassword());
        vmAdmins.setUsername(vmAdminsDto.getUsername());
        vmAdmins.setStatus(vmAdminsDto.getStatus());
        vmAdmins.setCreateTime(now);
        return vmAdmins;
    }

    @Override
    public VmAdmins getAdminById(Long userId, BasePo.Status status, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmAdminsMapper, userId, status, isDeleted);
    }

    @Override
    public VmAdmins getAdminById(Long userId, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmAdminsMapper, userId, isDeleted);
    }
}
