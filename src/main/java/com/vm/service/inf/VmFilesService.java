package com.vm.service.inf;

import com.vm.dao.po.VmFiles;

/**
 * Created by ZhangKe on 2017/12/13.
 */
public interface VmFilesService {
    VmFiles getFileByFileId(Long fileId) throws Exception;
}
