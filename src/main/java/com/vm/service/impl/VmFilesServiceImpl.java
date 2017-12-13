package com.vm.service.impl;

import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.po.VmFiles;
import com.vm.service.inf.VmFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangKe on 2017/12/13.
 */
@Service
public class VmFilesServiceImpl implements VmFilesService {
    @Autowired
    private VmFilesMapper vmFilesMapper;
    @Override
    public VmFiles getFileByFileId(Long fileId) {
        return vmFilesMapper.selectByPrimaryKey(fileId);
    }
}
