package com.vm.movie.service.impl;

import com.vm.base.util.BaseService;
import com.vm.base.util.Response;
import com.vm.dao.util.BasePo;
import com.vm.movie.config.MovieConfig;
import com.vm.movie.dao.mapper.*;
import com.vm.movie.dao.mapper.custom.CustomVmFilmmakersMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesSrcVersionMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsMapper;
import com.vm.movie.dao.po.VmMoviesSrcVersion;
import com.vm.movie.feign.service.SrcServiceClient;
import com.vm.movie.service.dto.VmMoviesSrcVersionDto;
import com.vm.movie.service.exception.VmMoviesSrcVersionsException;
import com.vm.movie.service.inf.VmMovieSrcVersionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@Service
public class VmMovieSrcVersionsServiceImpl extends BaseService implements VmMovieSrcVersionsService {
    private Logger logger = LoggerFactory.getLogger(VmMovieSrcVersionsServiceImpl.class);
    @Autowired
    private CustomVmMoviesMapper customVmMoviesMapper;
    @Autowired
    private VmMoviesMapper vmMoviesMapper;
    @Autowired
    private CustomVmTagsMapper customVmTagsMapper;
    @Autowired
    private VmTagsMapper vmTagsMapper;
    @Autowired
    private VmFilmmakersMapper vmFilmmakersMapper;
    @Autowired
    private CustomVmFilmmakersMapper customVmFilmmakersMapper;
    @Autowired
    private VmMoviesSrcVersionMapper vmMoviesSrcVersionMapper;
    @Autowired
    private CustomVmMoviesSrcVersionMapper customVmMoviesSrcVersionMapper;
    @Autowired
    private VmMoviesFilmmakersRealationMapper vmMoviesFilmmakersRealationMapper;
    @Autowired
    private VmMoviesTagsRealationMapper vmMoviesTagsRealationMapper;
    @Autowired
    private MovieConfig movieConfig;
    @Autowired
    private SrcServiceClient srcServiceClient;


    @Override
    public List<VmMoviesSrcVersionDto> getMovieSrcVersions(Long movieId) throws Exception {

//        VmMovies vmMovies = this.getVmMoviesById(movieId, BasePo.IsDeleted.NO);
//
//        if (isNullObject(vmMovies)) {
//            throw new VmMoviesException("getMovieFilmmakers vmMovies is not exist ! movieId is : " + movieId,
//                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
//                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
//        }

        return customVmMoviesSrcVersionMapper.selectMovieSrcVersionsByMovieId(movieId).stream().map((vmMoviesSrcVersion) -> {
            VmMoviesSrcVersionDto vmMoviesSrcVersionBo = new VmMoviesSrcVersionDto();
            vmMoviesSrcVersionBo.setId(vmMoviesSrcVersion.getId());
            vmMoviesSrcVersionBo.setSrcUrl(vmMoviesSrcVersion.getSrcUrl());
            vmMoviesSrcVersionBo.setSharpness(vmMoviesSrcVersion.getSharpness());
            return vmMoviesSrcVersionBo;
        }).collect(toList());
    }

    @Override
    @Transactional
    public void uploadVideo(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {
        logger.info("uploadVideo");
        String res = srcServiceClient.uploadVideo(vmMoviesSrcVersionDto.getFile());
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmMoviesSrcVersionsException("uploadVideo srcServiceClient#uploadVideo is fail !! vmMoviesSrcVersionDto is :" + vmMoviesSrcVersionDto);
        }

        String videoUrl = (String) response.getData("videoUrl");
        //update user
        VmMoviesSrcVersion vmMoviesSrcVersion = makeVmMovieSrcVersion(videoUrl, vmMoviesSrcVersionDto.getMovieId(), vmMoviesSrcVersionDto.getSharpness());
        if (1 != vmMoviesSrcVersionMapper.insert(vmMoviesSrcVersion)) {
            throw new VmMoviesSrcVersionsException("uploadVideo vmMoviesSrcVersionMapper#insert is fail !! vmMoviesDto is : " + vmMoviesSrcVersionDto);
        }
    }

    private VmMoviesSrcVersion makeVmMovieSrcVersion(String videoUrl, Long movieId, Byte sharpness) {
        VmMoviesSrcVersion vmMoviesSrcVersion = new VmMoviesSrcVersion();
        Integer now = now();
        vmMoviesSrcVersion.setMovieId(movieId);
        vmMoviesSrcVersion.setStatus(BasePo.Status.NORMAL.getCode());
        vmMoviesSrcVersion.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmMoviesSrcVersion.setSrcUrl(videoUrl);
        vmMoviesSrcVersion.setWeight(VmMoviesSrcVersion.DEFAULT_WEIGHT);
        vmMoviesSrcVersion.setSharpness(sharpness);
        vmMoviesSrcVersion.setPlayerSpeed(VmMoviesSrcVersion.DEFAULT_PLAYER_SPEED);
        vmMoviesSrcVersion.setCreateTime(now);
        vmMoviesSrcVersion.setUpdateTime(now);
        return vmMoviesSrcVersion;
    }


}
