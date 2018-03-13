package com.vm.user.service.impl;

import com.vm.base.util.BaseService;
import com.vm.base.util.PageBean;
import com.vm.user.dao.mapper.VmUsersLoginLogsMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersLoginLogsMapper;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import com.vm.user.service.dto.VmUsersLoginLogsDto;
import com.vm.user.service.inf.VmUsersLoginLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/13.
 */
@Service
public class VmUsersLoginLogsServiceImpl extends BaseService implements VmUsersLoginLogsService {
    @Autowired
    private CustomVmUsersLoginLogsMapper customVmUsersLoginLogsMapper;

    @Override
    public List<VmUsersLoginLogsDto> getUserLoginLogs(VmUsersLoginLogsQueryBean query, PageBean page) {
        return customVmUsersLoginLogsMapper.getUserLoginLogs(query, page);
    }

    @Override
    public Long getUserLoginLogsTotal(VmUsersLoginLogsQueryBean query, PageBean page) {
        return customVmUsersLoginLogsMapper.getUserLoginLogsTotal(query, page);
    }
}

