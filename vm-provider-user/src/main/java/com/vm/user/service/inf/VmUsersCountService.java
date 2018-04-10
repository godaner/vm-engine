package com.vm.user.service.inf;

import com.vm.user.service.dto.VmUsersLoginAreaCountDto;
import com.vm.user.service.dto.VmUsersSexCountDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public interface VmUsersCountService {
    void countUserSex();

    List<VmUsersSexCountDto> getUserSexCount();

    void countUserLoginArea();

    List<VmUsersLoginAreaCountDto> getUserAreaCount();
}
