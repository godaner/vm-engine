package com.vm.service.inf;

import com.vm.dao.po.VmFiles;
import com.vm.dao.qo.VmMoviesQueryBean;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/13.
 */
public interface VmFilesService {

    void getMovieImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception;
}
