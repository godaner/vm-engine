package com.vm.service.impl;

import com.vm.dao.po.VmTags;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.dao.mapper.VmMoviesMapper;
import com.vm.dao.po.CustomVmMovies;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@Service
public class VmMoviesServiceImpl extends BaseService implements VmMoviesService {
    @Autowired
    private VmMoviesMapper vmMoviesMapper;

    @Override
    public List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query) {
        return vmMoviesMapper.getMovies(page, query);
    }

    @Override
    public Long getMoviesCount(PageBean page, VmMoviesQueryBean query) {
        return vmMoviesMapper.getMoviesCount(page, query);
    }

    @Override
    public CustomVmMovies getMovie(Long movieId) {
        eject(movieId == null, "VmMoviesService#getMovie movieId is null ! movieId is :" + movieId);

        return vmMoviesMapper.getMovie(movieId);
    }


}
