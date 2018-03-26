package com.vm.admin.service.impl;

import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.base.util.BaseService;
import com.vm.dao.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAdminsServiceImpl extends BaseService implements VmAdminsService {

    @Override
    public List<VmAdminsDto> getAdmins(PageBean page, VmAdminsQueryBean query) {
        return null;
    }

    @Override
    public Long getAdminsTotal(PageBean page, VmAdminsQueryBean query) {
        return null;
    }
}
