package com.vm.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.cache.CountCacheManager;
import com.vm.dao.util.BasePo;
import com.vm.user.dao.mapper.custom.CustomVmUsersLoginLogsMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersMapper;
import com.vm.user.dao.po.custom.CustomVmUsersLoginAreaCount;
import com.vm.user.dao.po.custom.CustomVmUsersLoginSystemCount;
import com.vm.user.dao.po.custom.CustomVmUsersSexCount;
import com.vm.user.service.dto.VmUsersLoginAreaCountDto;
import com.vm.user.service.dto.VmUsersLoginSystemCountDto;
import com.vm.user.service.dto.VmUsersSexCountDto;
import com.vm.user.service.inf.VmUsersCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@Service
public class VmUsersCountServiceImpl implements VmUsersCountService {
    private final static String KEY_OF_USERS_SEX_COUNT = "userSexCount";
    private final static String KEY_OF_USERS_LOGIN_AREA_COUNT = "userLoginAreaCount";
    private final static String KEY_OF_USERS_LOGIN_SYSTEM_COUNT = "userLoginSystemCount";
    @Autowired
    private CustomVmUsersMapper customVmUsersMapper;

    @Autowired
    private CustomVmUsersLoginLogsMapper customVmUsersLoginLogsMapper;

    @Override
    public void countUserSex() {
        List<VmUsersSexCountDto> vmUsersSexCountDtos = customVmUsersMapper.countUserSex(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )).stream().parallel().map(customVmUsersSexCount -> {
            return makeVmUsersSexCountDtos(customVmUsersSexCount);
        }).collect(toList());

        CountCacheManager.saveCount(KEY_OF_USERS_SEX_COUNT, vmUsersSexCountDtos);
    }

    private VmUsersSexCountDto makeVmUsersSexCountDtos(CustomVmUsersSexCount customVmUsersSexCount) {
        VmUsersSexCountDto vmUsersSexCountDto = new VmUsersSexCountDto();
        vmUsersSexCountDto.setNumber(customVmUsersSexCount.getNumber());
        vmUsersSexCountDto.setSex(customVmUsersSexCount.getSex());
        return vmUsersSexCountDto;

    }

    @Override
    public List<VmUsersSexCountDto> getUserSexCount() {

        return (List<VmUsersSexCountDto>) CountCacheManager.getCount(KEY_OF_USERS_SEX_COUNT);
    }

    @Override
    public void countUserLoginArea() {
        List<VmUsersLoginAreaCountDto> vmUsersLoginAreaCountDtos = customVmUsersLoginLogsMapper.countUserLoginArea(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )).stream().parallel().map(vmUsersLoginAreaCount -> {
            return makeVmUsersLoginAreaCountDtos(vmUsersLoginAreaCount);
        }).collect(toList());

        CountCacheManager.saveCount(KEY_OF_USERS_LOGIN_AREA_COUNT, vmUsersLoginAreaCountDtos);
    }

    @Override
    public List<VmUsersLoginAreaCountDto> getUserLoginAreaCount() {
        return (List<VmUsersLoginAreaCountDto>) CountCacheManager.getCount(KEY_OF_USERS_LOGIN_AREA_COUNT);
    }

    @Override
    public List<VmUsersLoginSystemCountDto> getUserLoginSystemCount() {
        return (List<VmUsersLoginSystemCountDto>) CountCacheManager.getCount(KEY_OF_USERS_LOGIN_SYSTEM_COUNT);
    }

    @Override
    public void countUserLoginSystem() {
        List<VmUsersLoginSystemCountDto> vmUsersLoginSystemCountDtos = customVmUsersLoginLogsMapper.countUserLoginSystem(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )).stream().parallel().map(vmUsersLoginSystemCount -> {
            return makeVmUsersLoginSystemCountDtos(vmUsersLoginSystemCount);
        }).collect(toList());

        CountCacheManager.saveCount(KEY_OF_USERS_LOGIN_SYSTEM_COUNT, vmUsersLoginSystemCountDtos);
    }

    private VmUsersLoginSystemCountDto makeVmUsersLoginSystemCountDtos(CustomVmUsersLoginSystemCount vmUsersLoginSystemCount) {
        VmUsersLoginSystemCountDto vmUsersLoginSystemCountDto = new VmUsersLoginSystemCountDto();
        vmUsersLoginSystemCountDto.setNumber(vmUsersLoginSystemCount.getNumber());
        vmUsersLoginSystemCountDto.setSystem(vmUsersLoginSystemCount.getSystem());
        return vmUsersLoginSystemCountDto;
    }

    private VmUsersLoginAreaCountDto makeVmUsersLoginAreaCountDtos(CustomVmUsersLoginAreaCount vmUsersLoginAreaCount) {
        VmUsersLoginAreaCountDto vmUsersLoginAreaCountDto = new VmUsersLoginAreaCountDto();
        vmUsersLoginAreaCountDto.setNumber(vmUsersLoginAreaCount.getNumber());
        vmUsersLoginAreaCountDto.setArea(vmUsersLoginAreaCount.getArea());
        return vmUsersLoginAreaCountDto;
    }
}
