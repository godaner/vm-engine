package com.vm.user.service.inf;

import com.vm.user.service.dto.VmUsersCountDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public interface VmUsersCountService {
    void countUserSex();

    List<VmUsersCountDto> getUserSexCount();
}
