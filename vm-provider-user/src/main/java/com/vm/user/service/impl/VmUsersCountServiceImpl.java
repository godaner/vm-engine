package com.vm.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.CountCacheManager;
import com.vm.dao.util.BasePo;
import com.vm.user.dao.mapper.custom.CustomVmUsersMapper;
import com.vm.user.dao.po.custom.CustomVmUsersCount;
import com.vm.user.service.dto.VmUsersCountDto;
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
    @Autowired
    private CustomVmUsersMapper customVmUsersMapper;

    @Override
    public void countUserSex() {
        List<VmUsersCountDto> vmUsersCountDtos = customVmUsersMapper.countUserSex(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        )).stream().parallel().map(customVmUsersCount -> {
            return makeVmUsersCountDtos(customVmUsersCount);
        }).collect(toList());

        CountCacheManager.saveCount("KEY_OF_USERS_SEX_COUNT", vmUsersCountDtos);
    }

    private VmUsersCountDto makeVmUsersCountDtos(CustomVmUsersCount customVmUsersCount) {
        VmUsersCountDto vmUsersCountDto = new VmUsersCountDto();
        vmUsersCountDto.setNumber(customVmUsersCount.getNumber());
        vmUsersCountDto.setSex(customVmUsersCount.getSex());
        return vmUsersCountDto;
    }

    @Override
    public List<VmUsersCountDto> getUserSexCount() {

        return (List<VmUsersCountDto>) CountCacheManager.getCount("KEY_OF_USERS_SEX_COUNT");
    }
}
