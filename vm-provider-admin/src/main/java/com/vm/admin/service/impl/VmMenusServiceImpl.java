package com.vm.admin.service.impl;

import com.vm.admin.service.dto.VmAuthMenusDto;
import com.vm.admin.service.inf.VmMenusService;
import com.vm.base.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmMenusServiceImpl extends BaseService implements VmMenusService {


    @Override
    public List<VmAuthMenusDto> getMenuByAdminId(Long adminId) {
        return null;
    }
}
