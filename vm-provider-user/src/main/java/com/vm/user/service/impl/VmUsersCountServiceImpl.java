package com.vm.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.CountCacheManager;
import com.vm.dao.util.BasePo;
import com.vm.user.dao.mapper.custom.CustomVmUsersLoginLogsMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersMapper;
import com.vm.user.dao.po.custom.CustomVmUsersLoginAreaCount;
import com.vm.user.dao.po.custom.CustomVmUsersSexCount;
import com.vm.user.service.dto.VmUsersLoginAreaCountDto;
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

    private VmUsersLoginAreaCountDto makeVmUsersLoginAreaCountDtos(CustomVmUsersLoginAreaCount vmUsersLoginAreaCount) {
        VmUsersLoginAreaCountDto vmUsersLoginAreaCountDto = new VmUsersLoginAreaCountDto();
        vmUsersLoginAreaCountDto.setNumber(vmUsersLoginAreaCount.getNumber());
        vmUsersLoginAreaCountDto.setArea(vmUsersLoginAreaCount.getArea());
        return vmUsersLoginAreaCountDto;
    }
}
