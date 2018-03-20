package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.*;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.config.MovieConfig;
import com.vm.movie.dao.mapper.*;
import com.vm.movie.dao.mapper.custom.*;
import com.vm.movie.dao.po.*;
import com.vm.movie.dao.po.custom.*;
import com.vm.movie.dao.qo.*;
import com.vm.movie.feign.service.SrcServiceClient;
import com.vm.movie.service.dto.VmFilmmakersDto;
import com.vm.movie.service.dto.VmMoviesDto;
import com.vm.movie.service.dto.VmMoviesSrcVersionDto;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.exception.VmMoviesException;
import com.vm.movie.service.inf.VmMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@Service
public class VmMoviesServiceImpl extends BaseService implements VmMoviesService {
    @Autowired
    private CustomVmMoviesMapper customVmMoviesMapper;
    @Autowired
    private VmMoviesMapper vmMoviesMapper;
    @Autowired
    private CustomVmTagsMapper customVmTagsMapper;
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
    private MovieConfig movieConfig;
    @Autowired
    private SrcServiceClient srcServiceClient;

    /**
     * 构建含有基本电影信息的dto
     *
     * @param customVmMovies
     * @return
     */
    private VmMoviesDto makeBasicMovieDto(CustomVmMovies customVmMovies) {
        VmMoviesDto vmMoviesDto = new VmMoviesDto();
        vmMoviesDto.setDescription(customVmMovies.getDescription());
        vmMoviesDto.setDirectorId(customVmMovies.getDirectorId());
        vmMoviesDto.setId(customVmMovies.getId());
        vmMoviesDto.setImgUrl(customVmMovies.getImgUrl());
        vmMoviesDto.setMovieTime(customVmMovies.getMovieTime());
        vmMoviesDto.setName(customVmMovies.getName());
        vmMoviesDto.setPosterUrl(customVmMovies.getPosterUrl());
        vmMoviesDto.setReleaseTime(customVmMovies.getReleaseTime());
        vmMoviesDto.setScore(customVmMovies.getScore());
        vmMoviesDto.setWatchNum(customVmMovies.getWatchNum());
        vmMoviesDto.setReleaseTime(customVmMovies.getReleaseTime());
        vmMoviesDto.setAlias(customVmMovies.getAlias());
        return vmMoviesDto;
    }

    /**
     * 构建含有actors和director的dto集合
     *
     * @param aboutFilmmakersMovies
     * @return
     */
    private List<VmMoviesDto> makeMoviesWithDirectorAndActors(List<CustomVmMovies> aboutFilmmakersMovies) {
        return aboutFilmmakersMovies.stream().map((aboutTagsMovie) -> {
            VmMoviesDto vmMoviesDto = new VmMoviesDto();
            vmMoviesDto.setDescription(aboutTagsMovie.getAlias());
            vmMoviesDto.setDirectorId(aboutTagsMovie.getDirectorId());
            vmMoviesDto.setId(aboutTagsMovie.getId());
            vmMoviesDto.setImgUrl(aboutTagsMovie.getImgUrl());
            vmMoviesDto.setMovieTime(aboutTagsMovie.getMovieTime());
            vmMoviesDto.setName(aboutTagsMovie.getName());
            vmMoviesDto.setPosterUrl(aboutTagsMovie.getPosterUrl());
            vmMoviesDto.setReleaseTime(aboutTagsMovie.getReleaseTime());
            vmMoviesDto.setScore(aboutTagsMovie.getScore());
            vmMoviesDto.setWatchNum(aboutTagsMovie.getWatchNum());
            vmMoviesDto.setReleaseTime(aboutTagsMovie.getReleaseTime());
            vmMoviesDto.setActors(aboutTagsMovie.getActors());
            vmMoviesDto.setDirector(aboutTagsMovie.getDirector());
            return vmMoviesDto;
        }).collect(toList());
    }


    @Override
    public List<VmMoviesDto> getMovies(PageBean page, VmMoviesQueryBean query) {

        if (isEmptyList(query.getTagIds())) {
            query.setTagIdsLength(0);
        } else {
            query.setTagIdsLength(query.getTagIds().size());
        }
        return makeMoviesWithDirectorAndActors(customVmMoviesMapper.getMovies(page, query));
    }

    @Override
    public Long getMoviesCount(PageBean page, VmMoviesQueryBean query) {
        if (isEmptyList(query.getTagIds())) {
            query.setTagIdsLength(0);
        } else {
            query.setTagIdsLength(query.getTagIds().size());
        }
        return customVmMoviesMapper.getMoviesCount(page, query);
    }

    @Override
    public List<VmTagsDto> getTagsOfMovie(Long movieId) throws Exception {
        return customVmTagsMapper.getTagsIdAndNameOfMovie(movieId).stream().map((tag) -> {
            VmTagsDto vmTagsBo = new VmTagsDto();
            vmTagsBo.setId(tag.getId());
            vmTagsBo.setName(tag.getName());
            return vmTagsBo;
        }).collect(toList());
    }


    @Override
    public List<VmFilmmakersDto> getMovieFilmmakers(Long movieId) {

        VmMovies vmMovies = this.getVmMoviesById(movieId, BasePo.IsDeleted.NO);

        if (isNullObject(vmMovies)) {

            throw new VmMoviesException("getMovieFilmmakers vmMovies is not exist ! movieId is : " + movieId,
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
        }

        //返回集
        List<VmFilmmakers> filmmakers = Lists.newArrayList();

        //获取演员
        List<VmFilmmakers> actors = customVmFilmmakersMapper.selectActorsByMovieId(movieId);

        filmmakers.addAll(actors);
        //获取导演
        Long directorId = vmMovies.getDirectorId();
        if (!isNullObject(directorId)) {
            VmFilmmakers director = vmFilmmakersMapper.select(directorId);
            filmmakers.add(director);
        }

        return makeFilmmakerDtos(filmmakers);
    }


    private List<VmFilmmakersDto> makeFilmmakerDtos(List<VmFilmmakers> filmmakers) {
        //去除list的重复filmmaker
        if (isEmptyList(filmmakers)) {
            return Lists.newArrayList();
        }
        Map<Long, VmFilmmakers> map = Maps.newHashMap();
        for (VmFilmmakers filmmaker : filmmakers) {
            map.put(filmmaker.getId(), filmmaker);
        }
        //to dto
        return Lists.newArrayList(map.values()).stream().map((filmmaker) -> {
            VmFilmmakersDto vmFilmmakersDto = new VmFilmmakersDto();
            vmFilmmakersDto.setName(filmmaker.getName());
            vmFilmmakersDto.setId(filmmaker.getId());
            vmFilmmakersDto.setImgUrl(filmmaker.getImgUrl());
            return vmFilmmakersDto;
        }).collect(toList());
    }

    @Override
    public List<VmMoviesSrcVersionDto> getMovieSrcVersions(Long movieId) throws Exception {

        VmMovies vmMovies = this.getVmMoviesById(movieId, BasePo.IsDeleted.NO);

        if (isNullObject(vmMovies)) {
            throw new VmMoviesException("getMovieFilmmakers vmMovies is not exist ! movieId is : " + movieId,
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
        }

        return customVmMoviesSrcVersionMapper.selectMovieSrcVersionsByMovieId(movieId).stream().map((vmMoviesSrcVersion) -> {
            VmMoviesSrcVersionDto vmMoviesSrcVersionBo = new VmMoviesSrcVersionDto();
            vmMoviesSrcVersionBo.setId(vmMoviesSrcVersion.getId());
            vmMoviesSrcVersionBo.setSrcUrl(vmMoviesSrcVersion.getSrcUrl());
            vmMoviesSrcVersionBo.setSharpness(vmMoviesSrcVersion.getSharpness());
            return vmMoviesSrcVersionBo;
        }).collect(toList());
    }


    @Override
    public String getMoviePosterUrl(Long movieId) throws Exception {
        VmMovies vmMovies = this.getVmMoviesById(movieId, BasePo.IsDeleted.NO);

        if (isNullObject(vmMovies)) {
            throw new VmMoviesException("getMovieFilmmakers vmMovies is not exist ! movieId is : " + movieId,
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
        }

        return vmMovies.getPosterUrl();
    }


    @Override
    public List<VmMoviesDto> getAboutTagsMovies(PageBean page, VmMoviesQueryBean query) throws Exception {
        return makeMoviesWithDirectorAndActors(customVmMoviesMapper.getAboutTagsMovies(page, query));
    }


    @Override
    public List<VmMoviesDto> getAboutFilmmakersMovies(PageBean page, VmMoviesQueryBean query) {
        return makeMoviesWithDirectorAndActors(customVmMoviesMapper.getAboutFilmmakersMovies(page, query));
    }

    @Override
    public List<VmMoviesDto> getBackendMovies(VmMoviesQueryBean query, PageBean page) {
        return customVmMoviesMapper.getBackendMovies(query, page).stream().parallel().map(vmMovies -> {
            return makeBackendMoviesDto(vmMovies);
        }).collect(toList());
    }

    private VmMoviesDto makeBackendMoviesDto(VmMovies vmMovies) {
        VmMoviesDto vmMoviesDto = new VmMoviesDto();
        vmMoviesDto.setAlias(vmMovies.getAlias());
        vmMoviesDto.setDescription(vmMovies.getDescription());
        vmMoviesDto.setDirectorId(vmMovies.getDirectorId());
        vmMoviesDto.setId(vmMovies.getId());
        vmMoviesDto.setImgUrl(vmMovies.getImgUrl());
        vmMoviesDto.setMovieTime(vmMovies.getMovieTime());
        vmMoviesDto.setName(vmMovies.getName());
        vmMoviesDto.setPosterUrl(vmMovies.getPosterUrl());
        vmMoviesDto.setReleaseTime(vmMovies.getReleaseTime());
        vmMoviesDto.setWatchNum(vmMovies.getWatchNum());
        vmMoviesDto.setScore(vmMovies.getScore());
        vmMoviesDto.setCreateTime(vmMovies.getCreateTime());
        vmMoviesDto.setUpdateTime(vmMovies.getUpdateTime());
        vmMoviesDto.setStatus(vmMovies.getStatus());
        vmMoviesDto.setDescription(vmMovies.getDescription());
        return vmMoviesDto;
    }

    @Override
    public Long getBackendMoviesTotal(VmMoviesQueryBean query, PageBean page) {
        return customVmMoviesMapper.getBackendMoviesTotal(query, page);
    }

    @Override
    @Transactional
    public VmMoviesDto updateBackEndMoviesInfo(VmMoviesDto vmMoviesDto) {
        VmMovies vmMovies = this.getVmMoviesById(vmMoviesDto.getId(), BasePo.IsDeleted.NO);
        if (isNullObject(vmMovies)) {
            throw new VmMoviesException("updateBackEndMoviesInfo movie is not exits ! vmMoviesDto is : " + vmMoviesDto,
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
        }
        //update movie
        vmMovies = makeUpdateVmMovies(vmMoviesDto);
        if (1 != vmMoviesMapper.update(vmMovies.getId(), vmMovies)) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesMapper#update is fail ! vmMovies is : " + vmMovies);
        }
        //get now obj
        vmMovies = this.getVmMoviesById(vmMoviesDto.getId(), BasePo.IsDeleted.NO);
        //delete old realation
        int cnt = vmMoviesFilmmakersRealationMapper.batchUpdate(
                ImmutableMap.of(
                        "movieId", vmMovies.getId()
                ), ImmutableMap.of(
                        "isDeleted", BasePo.IsDeleted.YES.getCode()
                ));
        if (cnt < 0) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#deleteBy is fail ! vmMoviesDto is : " + vmMoviesDto);
        }


        //insert new realation
        String actorIdsStr = vmMoviesDto.getActorIds();
        if (isEmptyString(actorIdsStr)) {//without new realation
            return makeBackendMoviesDto(vmMovies);
        }
        List<Long> actorIds = Lists.newArrayList(actorIdsStr.split(",")).stream().parallel().map(idStr -> {
            return Long.valueOf(idStr);
        }).collect(toList());
        List<VmMoviesFilmmakersRealation> vmMoviesFilmmakersRealations = makeVmMoviesFilmmakersRealations(vmMovies, actorIds);

        if (vmMoviesFilmmakersRealations.size() != vmMoviesFilmmakersRealationMapper.batchInsert(vmMoviesFilmmakersRealations)) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#batchInsert is fail ! vmMoviesFilmmakersRealations is : " + vmMoviesFilmmakersRealations);
        }

        return makeBackendMoviesDto(vmMovies);
    }

    private List<VmMoviesFilmmakersRealation> makeVmMoviesFilmmakersRealations(VmMovies vmMovies, List<Long> actorIds) {
        return actorIds.stream().parallel().map(actorId -> {
            return makeVmMoviesFilmmakersRealation(vmMovies, actorId);
        }).collect(toList());
    }

    private VmMoviesFilmmakersRealation makeVmMoviesFilmmakersRealation(VmMovies vmMovies, Long actorId) {
        Integer now = now();
        VmMoviesFilmmakersRealation vmMoviesFilmmakersRealation = new VmMoviesFilmmakersRealation();
        vmMoviesFilmmakersRealation.setFilmmakerId(actorId);
        vmMoviesFilmmakersRealation.setMovieId(vmMovies.getId());
        vmMoviesFilmmakersRealation.setCreateTime(now);
        vmMoviesFilmmakersRealation.setUpdateTime(now);
        vmMoviesFilmmakersRealation.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmMoviesFilmmakersRealation.setStatus(BasePo.Status.NORMAL.getCode());
        return vmMoviesFilmmakersRealation;
    }

    @Override
    public VmMoviesDto updateImg(UpdateHeadImgInfo updateHeadImgInfo) {
        //set versions
        updateHeadImgInfo.setVersions(movieConfig.getMovieImgVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmMoviesException("updateImg srcServiceClient#cutUploadedImgFile is fail !! updateHeadImgInfo is :" + updateHeadImgInfo);
        }
        String imgUrl = (String) response.getData("imgUrl");
        //update user
        VmMovies vmMovies = new VmMovies();
        vmMovies.setId(updateHeadImgInfo.getId());
        vmMovies.setImgUrl(imgUrl);
        vmMoviesMapper.update(vmMovies.getId(), vmMovies);


        //get new user
        vmMovies = this.getVmMoviesById(vmMovies.getId(), BasePo.IsDeleted.NO);

        return vmMovies == null ? null : makeBackendMoviesDto(vmMovies);
    }

    @Override
    public VmMoviesDto updatePoster(UpdateHeadImgInfo updateHeadImgInfo) {
        //set versions
        updateHeadImgInfo.setVersions(movieConfig.getMoviePosterVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmMoviesException("updatePoster srcServiceClient#cutUploadedImgFile is fail !! updateHeadImgInfo is :" + updateHeadImgInfo);
        }
        String imgUrl = (String) response.getData("imgUrl");
        //update user
        VmMovies vmUsers = new VmMovies();
        vmUsers.setId(updateHeadImgInfo.getId());
        vmUsers.setPosterUrl(imgUrl);
        vmMoviesMapper.update(vmUsers.getId(), vmUsers);


        //get new user
        vmUsers = this.getVmMoviesById(vmUsers.getId(), BasePo.IsDeleted.NO);

        return vmUsers == null ? null : makeBackendMoviesDto(vmUsers);
    }

    @Override
    @Transactional
    public VmMoviesDto addBackEndMoviesInfo(VmMoviesDto vmMoviesDto) {

        VmMovies vmMovies = makeAddVmMovie(vmMoviesDto);

        //add movie
        if (1 != vmMoviesMapper.insert(vmMovies)) {
            throw new VmMoviesException("addBackEndMoviesInfo vmMoviesMapper#insert is fail ! vmMoviesDto is : " + vmMoviesDto);
        }

        vmMovies = this.getVmMoviesById(vmMovies.getId(), BasePo.IsDeleted.NO);

        //add realation
        String actorIdsStr = vmMoviesDto.getActorIds();
        if (isEmptyString(actorIdsStr)) {//without new realation
            return makeBackendMoviesDto(vmMovies);
        }
        List<Long> actorIds = Lists.newArrayList(actorIdsStr.split(",")).stream().parallel().map(idStr -> {
            return Long.valueOf(idStr);
        }).collect(toList());
        List<VmMoviesFilmmakersRealation> vmMoviesFilmmakersRealations = makeVmMoviesFilmmakersRealations(vmMovies, actorIds);

        if (vmMoviesFilmmakersRealations.size() != vmMoviesFilmmakersRealationMapper.batchInsert(vmMoviesFilmmakersRealations)) {
            throw new VmMoviesException("addBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#batchInsert is fail ! vmMoviesFilmmakersRealations is : " + vmMoviesFilmmakersRealations);
        }

        return makeBackendMoviesDto(vmMovies);
    }

    private VmMovies makeAddVmMovie(VmMoviesDto vmMoviesDto) {
        Integer now = now();
        VmMovies vmMovies = new VmMovies();
        vmMovies.setStatus(vmMoviesDto.getStatus());
        vmMovies.setReleaseTime(vmMoviesDto.getReleaseTime());
        vmMovies.setCreateTime(now);
        vmMovies.setUpdateTime(now);
        vmMovies.setName(vmMoviesDto.getName());
        vmMovies.setDescription(vmMoviesDto.getDescription());
        vmMovies.setMovieTime(vmMoviesDto.getMovieTime());
        vmMovies.setAlias(vmMoviesDto.getAlias());
        vmMovies.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmMovies.setScore(VmMovies.DEFAULT_SCORE);
        vmMovies.setWatchNum(VmMovies.DEFAULT_WATCH_NUM);
        vmMovies.setPosterUrl(VmMovies.DEFAULT_POSTER_URL);
        vmMovies.setImgUrl(VmMovies.DEFAULT_IMG_URL);
        vmMovies.setDirectorId(vmMoviesDto.getDirectorId());
        return vmMovies;
    }

    private VmMovies getVmMoviesById(Long id, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmMoviesMapper, id, isDeleted);

    }

    private VmMovies getVmMoviesById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmMoviesMapper, id, status, isDeleted);

    }


    private VmMovies makeUpdateVmMovies(VmMoviesDto vmMoviesDto) {
        VmMovies vmMovies = new VmMovies();
        Integer now = DateUtil.unixTime().intValue();
        vmMovies.setUpdateTime(now);
        vmMovies.setAlias(vmMoviesDto.getAlias());
        vmMovies.setDescription(vmMoviesDto.getDescription());
        vmMovies.setMovieTime(vmMoviesDto.getMovieTime());
        vmMovies.setName(vmMoviesDto.getName());
        vmMovies.setReleaseTime(vmMoviesDto.getReleaseTime());
        vmMovies.setId(vmMoviesDto.getId());
        vmMovies.setStatus(vmMoviesDto.getStatus());
        vmMovies.setDirectorId(vmMoviesDto.getDirectorId());
        vmMovies.setUpdateTime(now);
        return vmMovies;
    }


    @Override
    public VmMoviesDto getMovie(Long movieId) {

        return makeBasicMovieDto(customVmMoviesMapper.getMovie(movieId));
    }


}
