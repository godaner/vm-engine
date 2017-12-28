package com.vm.service.inf;

import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.qo.VmFilmmakersQueryBean;
import com.vm.dao.qo.VmMoviesQueryBean;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/26.
 */
public interface FilmmakersService {
    void sendFilmmakerImg(Long filmmakerId, VmFilmmakersQueryBean query, HttpServletResponse response) throws Exception;

    VmFilmmakers getFilmmaker(Long filmmakerId) throws Exception;
}
