package com.vm.service.inf;

import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.dao.po.CustomVmMovies;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public interface VmMoviesService {
    List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query);

    Long getMoviesCount(PageBean page, VmMoviesQueryBean query);
}
