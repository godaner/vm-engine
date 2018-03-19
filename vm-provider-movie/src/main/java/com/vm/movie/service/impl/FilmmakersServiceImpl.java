package com.vm.movie.service.impl;

import com.vm.dao.util.BasePo;
import com.vm.base.util.BaseService;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.dao.mapper.VmFilmmakersMapper;
import com.vm.movie.dao.mapper.custom.CustomVmFilmmakersMapper;
import com.vm.movie.dao.po.VmFilmmakers;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.service.dto.VmFilmmakersDto;
import com.vm.movie.service.inf.FilmmakersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/26.
 */
@Service
public class FilmmakersServiceImpl extends BaseService implements FilmmakersService {

    @Autowired
    private VmFilmmakersMapper vmFilmmakersMapper;

    @Autowired
    private CustomVmFilmmakersMapper customVmFilmmakersMapper;

    private VmFilmmakersDto makeBasicFilmmakerDto(VmFilmmakers filmmaker) {
        VmFilmmakersDto vmFilmmakersDto = new VmFilmmakersDto();
        vmFilmmakersDto.setAlias(filmmaker.getAlias());
        vmFilmmakersDto.setBirthday(filmmaker.getBirthday());
        vmFilmmakersDto.setBloodType(filmmaker.getBloodType());
        vmFilmmakersDto.setConstellation(filmmaker.getConstellation());
        vmFilmmakersDto.setCountry(filmmaker.getCountry());
        vmFilmmakersDto.setDescription(filmmaker.getDescription());
        vmFilmmakersDto.setId(filmmaker.getId());
        vmFilmmakersDto.setImgUrl(filmmaker.getImgUrl());
        vmFilmmakersDto.setProfession(filmmaker.getProfession());
        vmFilmmakersDto.setSex(filmmaker.getSex());
        vmFilmmakersDto.setName(filmmaker.getName());
        return vmFilmmakersDto;
    }

//    @Override
//    public void sendFilmmakerImg(Long filmmakerId, Integer width, HttpServletResponse response) throws Exception {
//        FileInputStream input = null;
//        ServletOutputStream output = null;
//        try {
//            if (isNullObject(width)) {
//                width = 300;
//            }
//            //获取电影图片id信息
//            VmFiles file = vmFilesMapper.select(filmmakerId);
//            String USERImgPath = Config.VM_FILMMAKER_IMG_PATH;
//            String USERImgName = null;
//            String contentType = null;
//            if (file != null) {
//                USERImgName = file.getFilename();
//                contentType = file.getContentType();
//            }
//            File f = new File(USERImgPath + File.separator + width + "_" + USERImgName);
//            //不存在，返回默认图片
//            if (!f.exists()) {
//                f = new File(USERImgPath + File.separator + ServerConfig.VM_FILMMAKER_IMG_DEFAULT_NAME);
//            }
//            input = new FileInputStream(f);
//            output = response.getOutputStream();
//            //设置响应的媒体类型
//            response.setContentType(contentType); // 设置返回的文件类型
//            IOUtils.copy(input, output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(input, output);
//        }
//    }

    @Override
    public VmFilmmakersDto getFilmmakerBasicInfo(Long filmmakerId) throws Exception {

        VmFilmmakers filmmaker = this.getFilmmakerById(filmmakerId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
        return filmmaker == null?null:makeBasicFilmmakerDto(filmmaker);
    }

    private VmFilmmakers getFilmmakerById(Long filmmakerId, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmFilmmakersMapper, filmmakerId, isDeleted);
    }

    private VmFilmmakers getFilmmakerById(Long filmmakerId, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmFilmmakersMapper, filmmakerId, status, isDeleted);
    }

    @Override
    public List<VmFilmmakersDto> getFilmmakers(PageBean page, VmFilmmakerQueryBean query) {
        return customVmFilmmakersMapper.getFilmmakers(page,query).stream().parallel().map(vmFilmmakers -> {
            return makeBackendFilmmakerDto(vmFilmmakers);
        }).collect(toList());
    }

    private VmFilmmakersDto makeBackendFilmmakerDto(VmFilmmakers vmFilmmakers) {
        VmFilmmakersDto vmFilmmakersDto = new VmFilmmakersDto();
        vmFilmmakersDto.setAlias(vmFilmmakers.getAlias());
        vmFilmmakersDto.setBirthday(vmFilmmakers.getBirthday());
        vmFilmmakersDto.setBloodType(vmFilmmakers.getBloodType());
        vmFilmmakersDto.setConstellation(vmFilmmakers.getConstellation());
        vmFilmmakersDto.setCountry(vmFilmmakers.getCountry());
        vmFilmmakersDto.setDescription(vmFilmmakers.getDescription());
        vmFilmmakersDto.setId(vmFilmmakers.getId());
        vmFilmmakersDto.setImgUrl(vmFilmmakers.getImgUrl());
        vmFilmmakersDto.setProfession(vmFilmmakers.getProfession());
        vmFilmmakersDto.setSex(vmFilmmakers.getSex());
        vmFilmmakersDto.setName(vmFilmmakers.getName());
        vmFilmmakersDto.setUpdateTime(vmFilmmakers.getUpdateTime());
        vmFilmmakersDto.setCreateTime(vmFilmmakers.getCreateTime());
        vmFilmmakersDto.setStatus(vmFilmmakers.getStatus());
        return vmFilmmakersDto;
    }

    @Override
    public Long getFilmmakersTotal(PageBean page, VmFilmmakerQueryBean query) {
        return customVmFilmmakersMapper.getFilmmakersTotal(page,query);
    }


}
