package com.vm.movie.service.inf;

import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.dao.util.PageBean;
import com.vm.movie.dao.po.VmFilmmakers;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.service.dto.VmFilmmakersDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/26.
 */
public interface FilmmakersService {
//    void sendFilmmakerImg(Long filmmakerId, Integer width, HttpServletResponse response) throws Exception;

    VmFilmmakersDto getFilmmakerBasicInfo(Long filmmakerId) throws Exception;

    List<VmFilmmakersDto> getFilmmakers(PageBean page, VmFilmmakerQueryBean query);

    Long getFilmmakersTotal(PageBean page, VmFilmmakerQueryBean query);

    VmFilmmakersDto addFilmmaker(VmFilmmakersDto vmFilmmakersDto);

    VmFilmmakersDto editFilmmaker(VmFilmmakersDto vmFilmmakersDto);

    VmFilmmakersDto updateImg(UpdateHeadImgInfo updateHeadImgInfo);
}
