package com.vm.frontend.service.inf;

import com.vm.frontend.service.dto.VmFilmmakersDto;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/26.
 */
public interface FilmmakersService {
    void sendFilmmakerImg(Long filmmakerId, Integer width, HttpServletResponse response) throws Exception;

    VmFilmmakersDto getFilmmakerBasicInfo(Long filmmakerId) throws Exception;
}
