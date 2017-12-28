package com.vm.service.impl;

import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.mapper.VmFilmmakersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.qo.VmFilmmakersQueryBean;
import com.vm.service.base.BaseService;
import com.vm.service.inf.FilmmakersService;
import com.vm.utils.VmProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by ZhangKe on 2017/12/26.
 */
@Service
public class FilmmakersServiceImpl extends BaseService implements FilmmakersService {

    @Autowired
    private VmFilesMapper vmFilesMapper;
    @Autowired
    private VmFilmmakersMapper vmFilmmakersMapper;

    @Override
    public void sendFilmmakerImg(Long filmmakerId, VmFilmmakersQueryBean query, HttpServletResponse response) throws Exception {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(filmmakerId);
            String USERImgPath = VmProperties.VM_USER_IMG_PATH;
            String width = query.getImgWidth();
            String USERImgName = null;
            if (file != null) {
                USERImgName = file.getFilename();
            }
            File f = new File(USERImgPath + File.separator + width + "_" + USERImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(USERImgPath + File.separator + VmProperties.VM_USER_IMG_DEFAULT_NAME);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
            response.setContentType(file.getContentType()); // 设置返回的文件类型
            IOUtils.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }

    @Override
    public VmFilmmakers getFilmmakerBasicInfo(Long filmmakerId) throws Exception {

        eject(isNullObject(filmmakerId),
                "getFilmmakerBasicInfo filmmakerId is null! filmmakerId is:" + filmmakerId);


        VmFilmmakers filmmaker = vmFilmmakersMapper.selectByPrimaryKey(filmmakerId);
        if (filmmaker != null && BasePo.Status.isDeleted(filmmaker.getStatus())) {
            return null;
        }

        return filmmaker;
    }
}
