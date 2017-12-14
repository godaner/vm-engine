package com.vm.service.impl;

import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.dao.mapper.VmMoviesMapper;
import com.vm.dao.po.CustomVmMovies;
import com.vm.service.inf.VmMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@Service
public class VmMoviesServiceImpl implements VmMoviesService {
    @Autowired
    private VmMoviesMapper vmMoviesMapper;
    @Override
    public List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query) {
        if((query.getTagIds()==null||query.getTagIds().size()==0)&&(query.getTagGroupIds()==null||query.getTagGroupIds().size()==0)){
            throw new RuntimeException("getMovies tagIds and tagGroupIds can not be null together!");
        }
        return vmMoviesMapper.getMovies(page,query);
    }

    @Override
    public Long getMoviesCount(PageBean page, VmMoviesQueryBean query) {
        return vmMoviesMapper.getMoviesCount(page,query);
    }
}
