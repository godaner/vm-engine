package com.vm.user.service.impl;

import com.vm.base.util.BaseService;
import com.vm.base.util.PageBean;
import com.vm.user.dao.mapper.VmUsersLoginLogsMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersLoginLogsMapper;
import com.vm.user.dao.po.VmUsersLoginLogs;
import com.vm.user.dao.po.custom.CustomVmUsersLoginLogs;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import com.vm.user.service.dto.VmUsersLoginLogsDto;
import com.vm.user.service.inf.VmUsersLoginLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/13.
 */
@Service
public class VmUsersLoginLogsServiceImpl extends BaseService implements VmUsersLoginLogsService {
    @Autowired
    private CustomVmUsersLoginLogsMapper customVmUsersLoginLogsMapper;

    @Override
    public List<VmUsersLoginLogsDto> getUserLoginLogs(VmUsersLoginLogsQueryBean query, PageBean page) {
        return customVmUsersLoginLogsMapper.getUserLoginLogs(query, page).stream().parallel().map(customVmUsersLoginLogs -> {
            return makeVmUsersLoginLogsDto(customVmUsersLoginLogs);
        }).collect(toList());
    }

    private VmUsersLoginLogsDto makeVmUsersLoginLogsDto(CustomVmUsersLoginLogs customVmUsersLoginLogs) {
        VmUsersLoginLogsDto vmUsersLoginLogsDto = new VmUsersLoginLogsDto();
        vmUsersLoginLogsDto.setUserId(customVmUsersLoginLogs.getUserId());
        vmUsersLoginLogsDto.setBrower(customVmUsersLoginLogs.getBrower());
        vmUsersLoginLogsDto.setCity(customVmUsersLoginLogs.getCity());
        vmUsersLoginLogsDto.setDpi(customVmUsersLoginLogs.getDpi());
        vmUsersLoginLogsDto.setCountry(customVmUsersLoginLogs.getCountry());
        vmUsersLoginLogsDto.setLoginIp(customVmUsersLoginLogs.getLoginIp());
        vmUsersLoginLogsDto.setLoginTime(customVmUsersLoginLogs.getLoginTime());
        vmUsersLoginLogsDto.setProvince(customVmUsersLoginLogs.getProvince());
        vmUsersLoginLogsDto.setResult(customVmUsersLoginLogs.getResult());
        vmUsersLoginLogsDto.setUsername(customVmUsersLoginLogs.getUsername());
        vmUsersLoginLogsDto.setSystem(customVmUsersLoginLogs.getSystem());
        return vmUsersLoginLogsDto;
    }

    @Override
    public Long getUserLoginLogsTotal(VmUsersLoginLogsQueryBean query, PageBean page) {
        return customVmUsersLoginLogsMapper.getUserLoginLogsTotal(query, page);
    }

}

