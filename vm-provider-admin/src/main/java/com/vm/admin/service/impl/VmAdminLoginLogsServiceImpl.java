package com.vm.admin.service.impl;

import com.vm.admin.dao.mapper.custom.CustomVmAdminsLoginLogsMapper;
import com.vm.admin.dao.po.custom.CustomVmAdminsLoginLogs;
import com.vm.admin.dao.qo.VmAdminLoginLogsQueryBean;
import com.vm.admin.service.dto.VmAdminLoginLogsDto;
import com.vm.admin.service.inf.VmAdminLoginLogsService;
import com.vm.dao.util.PageBean;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/27.
 */
public class VmAdminLoginLogsServiceImpl implements VmAdminLoginLogsService {
    CustomVmAdminsLoginLogsMapper customVmAdminsLoginLogsMapper;

    @Override
    public List<VmAdminLoginLogsDto> getLoginLogs(PageBean page, VmAdminLoginLogsQueryBean query) {
        List<CustomVmAdminsLoginLogs> vmAdminsLoginLogs = customVmAdminsLoginLogsMapper.getLoginLogs(page, query);
        return makeVmAdminsLoginLogsDtos(vmAdminsLoginLogs);
    }

    private List<VmAdminLoginLogsDto> makeVmAdminsLoginLogsDtos(List<CustomVmAdminsLoginLogs> customVmAdminsLoginLogs) {
        return customVmAdminsLoginLogs.stream().parallel().map(customVmAdminsLoginLog -> {
            return makeVmAdminsLoginLogsDto(customVmAdminsLoginLog);
        }).collect(toList());
    }

    private VmAdminLoginLogsDto makeVmAdminsLoginLogsDto(CustomVmAdminsLoginLogs customVmAdminsLoginLogs) {
        VmAdminLoginLogsDto vmAdminLoginLogsDto = new VmAdminLoginLogsDto();
        vmAdminLoginLogsDto.setAdminId(customVmAdminsLoginLogs.getAdminId());
        vmAdminLoginLogsDto.setBrower(customVmAdminsLoginLogs.getBrower());
        vmAdminLoginLogsDto.setCity(customVmAdminsLoginLogs.getCity());
        vmAdminLoginLogsDto.setDpi(customVmAdminsLoginLogs.getDpi());
        vmAdminLoginLogsDto.setCountry(customVmAdminsLoginLogs.getCountry());
        vmAdminLoginLogsDto.setLoginIp(customVmAdminsLoginLogs.getLoginIp());
        vmAdminLoginLogsDto.setLoginTime(customVmAdminsLoginLogs.getLoginTime());
        vmAdminLoginLogsDto.setProvince(customVmAdminsLoginLogs.getProvince());
        vmAdminLoginLogsDto.setResult(customVmAdminsLoginLogs.getResult());
        vmAdminLoginLogsDto.setUsername(customVmAdminsLoginLogs.getUsername());
        vmAdminLoginLogsDto.setSystem(customVmAdminsLoginLogs.getSystem());
        vmAdminLoginLogsDto.setId(customVmAdminsLoginLogs.getId());
        return vmAdminLoginLogsDto;
    }

    @Override
    public Long getLoginLogsTotal(PageBean page, VmAdminLoginLogsQueryBean query) {
        return customVmAdminsLoginLogsMapper.getLoginLogsTotal(page, query);

    }
}
