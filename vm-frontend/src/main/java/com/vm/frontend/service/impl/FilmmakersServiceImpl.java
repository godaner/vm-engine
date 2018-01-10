package com.vm.frontend.service.impl;

import com.vm.base.utils.BaseService;
import com.vm.base.utils.VmProperties;
import com.vm.frontend.service.dto.VmFilmmakersDto;
import com.vm.frontend.service.inf.FilmmakersService;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.mapper.VmFilmmakersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmFilmmakers;
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
    public void sendFilmmakerImg(Long filmmakerId, Integer width, HttpServletResponse response) throws Exception {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(filmmakerId);
            String USERImgPath = VmProperties.VM_FILMMAKER_IMG_PATH;
            String USERImgName = null;
            if (file != null) {
                USERImgName = file.getFilename();
            }
            File f = new File(USERImgPath + File.separator + width + "_" + USERImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(USERImgPath + File.separator + VmProperties.VM_FILMMAKER_IMG_DEFAULT_NAME);
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
    public VmFilmmakersDto getFilmmakerBasicInfo(Long filmmakerId) throws Exception {

        VmFilmmakers filmmaker = vmFilmmakersMapper.selectByPrimaryKey(filmmakerId);
        if (filmmaker != null && BasePo.Status.isDeleted(filmmaker.getStatus())) {
            return null;
        }
        return makeFilmmakerBo(filmmaker);
    }

    private VmFilmmakersDto makeFilmmakerBo(VmFilmmakers filmmaker) {
        VmFilmmakersDto vmFilmmakersBo = new VmFilmmakersDto();
        vmFilmmakersBo.setAlias(filmmaker.getAlias());
        vmFilmmakersBo.setBirthday(filmmaker.getBirthday());
        vmFilmmakersBo.setBloodType(filmmaker.getBloodType());
        vmFilmmakersBo.setConstellation(filmmaker.getConstellation());
        vmFilmmakersBo.setCountry(filmmaker.getCountry());
        vmFilmmakersBo.setDescription(filmmaker.getDescription());
        vmFilmmakersBo.setId(filmmaker.getId());
        vmFilmmakersBo.setImgUrl(filmmaker.getImgUrl());
        vmFilmmakersBo.setProfession(filmmaker.getProfession());
        vmFilmmakersBo.setSex(filmmaker.getSex());
        vmFilmmakersBo.setName(filmmaker.getName());
        return vmFilmmakersBo;
    }
}
