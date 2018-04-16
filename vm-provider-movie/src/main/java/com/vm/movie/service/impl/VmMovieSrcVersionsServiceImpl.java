package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.BaseService;
import com.vm.base.util.Response;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.config.MovieConfig;
import com.vm.movie.dao.mapper.*;
import com.vm.movie.dao.mapper.custom.CustomVmFilmmakersMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesSrcVersionMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsMapper;
import com.vm.movie.dao.po.VmMoviesSrcVersion;
import com.vm.movie.feign.service.SrcServiceClient;
import com.vm.movie.service.dto.VmMoviesSrcVersionDto;
import com.vm.movie.service.exception.VmFilmmakersException;
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
        List<VmMoviesSrcVersion> vmMoviesSrcVersions = vmMoviesSrcVersionMapper.selectBy(ImmutableMap.of(
                "movieId", movieId,
                "status", BasePo.Status.NORMAL.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
        return vmMoviesSrcVersions.stream().map((vmMoviesSrcVersion) -> {
            VmMoviesSrcVersionDto vmMoviesSrcVersionBo = new VmMoviesSrcVersionDto();
            vmMoviesSrcVersionBo.setId(vmMoviesSrcVersion.getId());
            vmMoviesSrcVersionBo.setSrcUrl(vmMoviesSrcVersion.getSrcUrl());
            vmMoviesSrcVersionBo.setSharpness(vmMoviesSrcVersion.getSharpness());
            return vmMoviesSrcVersionBo;
        }).collect(toList());
    }

    @Override
    @Transactional
    public VmMoviesSrcVersionDto addMovieSrcVersion(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {
        logger.info("addMovieSrcVersion start !");
        String res = srcServiceClient.uploadVideo(vmMoviesSrcVersionDto.getFile());
        logger.info("addMovieSrcVersion srcServiceClient#uploadVideo res is : " + jsonLogger(res));
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmMoviesSrcVersionsException("addMovieSrcVersion srcServiceClient#addMovieSrcVersion is fail !! vmMoviesSrcVersionDto is :" + vmMoviesSrcVersionDto);
        }

        String videoUrl = (String) response.getData("videoUrl");
        //update user
        VmMoviesSrcVersion vmMoviesSrcVersion = makeVmMovieSrcVersion(videoUrl, vmMoviesSrcVersionDto);
        if (1 != vmMoviesSrcVersionMapper.insert(vmMoviesSrcVersion)) {
            throw new VmMoviesSrcVersionsException("addMovieSrcVersion vmMoviesSrcVersionMapper#insert is fail !! vmMoviesDto is : " + vmMoviesSrcVersionDto);
        }
        vmMoviesSrcVersion = this.getVmMovieSrcVersionById(vmMoviesSrcVersion.getId(), BasePo.IsDeleted.NO);

        return makeVmMoviesSrcVersionsDto(vmMoviesSrcVersion);
    }

    @Override
    public VmMoviesSrcVersion getVmMovieSrcVersionById(Long id, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmMoviesSrcVersionMapper, id, isDeleted);

    }

    @Override
    public VmMoviesSrcVersion getVmMovieSrcVersionById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmMoviesSrcVersionMapper, id, status, isDeleted);

    }

    @Override
    public List<VmMoviesSrcVersionDto> getAllVersionsByMovieId(Long movieId) {

        List<VmMoviesSrcVersion> vmMoviesSrcVersions = vmMoviesSrcVersionMapper.selectBy(ImmutableMap.of(
                "movieId", movieId,
//                "status", BasePo.Status.NORMAL.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));

        return makeVmMoviesSrcVersionsDtos(vmMoviesSrcVersions);
    }

    @Override
    public VmMoviesSrcVersionDto updateMovieSrcVersion(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {

        VmMoviesSrcVersion vmMovieSrcVersion = this.getVmMovieSrcVersionById(vmMoviesSrcVersionDto.getId(), BasePo.IsDeleted.NO);
        if (isNullObject(vmMovieSrcVersion)) {
            throw new VmMoviesSrcVersionsException("updateMovieSrcVersion version is not exits !! vmMoviesSrcVersionDto is : " + vmMoviesSrcVersionDto,
                    VmMoviesSrcVersionsException.ErrorCode.VERSION_IS_NOT_EXITS.getCode(),
                    VmMoviesSrcVersionsException.ErrorCode.VERSION_IS_NOT_EXITS.getMsg());
        }
        vmMovieSrcVersion = makeUpdateVmMoviesSrcVersion(vmMoviesSrcVersionDto);
        if (1 != vmMoviesSrcVersionMapper.update(vmMoviesSrcVersionDto.getId(), vmMovieSrcVersion)) {
            throw new VmMoviesSrcVersionsException("updateMovieSrcVersion vmMoviesSrcVersionMapper#update is fail !! vmMoviesSrcVersionDto is : " + vmMoviesSrcVersionDto);
        }

        vmMovieSrcVersion = this.getVmMovieSrcVersionById(vmMoviesSrcVersionDto.getId(), BasePo.IsDeleted.NO);
        return makeVmMoviesSrcVersionsDto(vmMovieSrcVersion);

    }

    @Override
    public void deleteMovieSrcVersions(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {
        int cnt = 0;
        String deletedIdsStr = vmMoviesSrcVersionDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmFilmmakersException("deleteMovieSrcVersions deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(vmMoviesSrcVersionDto.getDeletedIds());

        if (!isEmptyList(deletedIds)) {
            cnt = vmMoviesSrcVersionMapper.updateInIds(deletedIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != deletedIds.size()) {
                throw new VmFilmmakersException("deleteMovieSrcVersions vmMoviesSrcVersionMapper#updateInIds is fail ! deleteIds is : " + deletedIds);
            }

        }


    }

    private VmMoviesSrcVersion makeUpdateVmMoviesSrcVersion(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {
        VmMoviesSrcVersion vmMoviesSrcVersion = new VmMoviesSrcVersion();
        Integer now = now();
        vmMoviesSrcVersion.setStatus(vmMoviesSrcVersionDto.getStatus());
        vmMoviesSrcVersion.setSharpness(vmMoviesSrcVersionDto.getSharpness());
        vmMoviesSrcVersion.setUpdateTime(now);
        return vmMoviesSrcVersion;
    }

    private List<VmMoviesSrcVersionDto> makeVmMoviesSrcVersionsDtos(List<VmMoviesSrcVersion> vmMoviesSrcVersions) {
        return vmMoviesSrcVersions.stream().parallel().map(vmMoviesSrcVersion -> {
            return makeVmMoviesSrcVersionsDto(vmMoviesSrcVersion);
        }).collect(toList());
    }

    private VmMoviesSrcVersionDto makeVmMoviesSrcVersionsDto(VmMoviesSrcVersion vmMoviesSrcVersion) {
        VmMoviesSrcVersionDto vmMoviesSrcVersionDto = new VmMoviesSrcVersionDto();
        vmMoviesSrcVersionDto.setSharpness(vmMoviesSrcVersion.getSharpness());
        vmMoviesSrcVersionDto.setCreateTime(vmMoviesSrcVersion.getCreateTime());
        vmMoviesSrcVersionDto.setId(vmMoviesSrcVersion.getId());
        vmMoviesSrcVersionDto.setUpdateTime(vmMoviesSrcVersion.getUpdateTime());
        vmMoviesSrcVersionDto.setStatus(vmMoviesSrcVersion.getStatus());
        vmMoviesSrcVersionDto.setMovieId(vmMoviesSrcVersion.getMovieId());
        return vmMoviesSrcVersionDto;

    }

    private VmMoviesSrcVersion makeVmMovieSrcVersion(String videoUrl, VmMoviesSrcVersionDto vmMoviesSrcVersionDto) {
        VmMoviesSrcVersion vmMoviesSrcVersion = new VmMoviesSrcVersion();
        Integer now = now();
        vmMoviesSrcVersion.setMovieId(vmMoviesSrcVersionDto.getMovieId());
        vmMoviesSrcVersion.setStatus(BasePo.Status.NORMAL.getCode());
        vmMoviesSrcVersion.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmMoviesSrcVersion.setSrcUrl(videoUrl);
        vmMoviesSrcVersion.setWeight(VmMoviesSrcVersion.DEFAULT_WEIGHT);
        vmMoviesSrcVersion.setSharpness(vmMoviesSrcVersionDto.getSharpness());
        vmMoviesSrcVersion.setPlayerSpeed(VmMoviesSrcVersion.DEFAULT_PLAYER_SPEED);
        vmMoviesSrcVersion.setCreateTime(now);
        vmMoviesSrcVersion.setUpdateTime(now);
        return vmMoviesSrcVersion;
    }


}
