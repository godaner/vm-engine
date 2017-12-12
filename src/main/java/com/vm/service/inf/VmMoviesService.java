package com.vm.service.inf;

import com.vm.base.utils.PageBean;
import com.vm.dao.bo.VmMoviesQueryBean;
import com.vm.dao.po.CustomVmMovies;
import com.vm.dao.po.VmMovies;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public interface VmMoviesService {
    List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query);

    Long getMoviesCount(PageBean page, VmMoviesQueryBean query);
}
