package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.BaseService;
import com.vm.base.util.BeanMapUtil;
import com.vm.base.util.DateUtil;
import com.vm.base.util.Response;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.config.VmMovieConfig;
import com.vm.movie.dao.mapper.*;
import com.vm.movie.dao.mapper.custom.*;
import com.vm.movie.dao.po.VmMovies;
import com.vm.movie.dao.po.VmMoviesFilmmakersRealation;
import com.vm.movie.dao.po.VmMoviesTagsRealation;
import com.vm.movie.dao.po.custom.CustomVmMovies;
import com.vm.movie.dao.qo.VmMoviesQueryBean;
import com.vm.movie.feign.service.SrcServiceClient;
import com.vm.movie.service.dto.VmMoviesDto;
import com.vm.movie.service.exception.VmMoviesException;
import com.vm.movie.service.inf.VmMoviesService;
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
public class VmMoviesServiceImpl extends BaseService implements VmMoviesService {
    private Logger logger = LoggerFactory.getLogger(VmMoviesServiceImpl.class);
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
    CustomVmMoviesFilmmakersRealationMapper customVmMoviesFilmmakersRealationMapper;
    @Autowired
    CustomVmMoviesTagsRealationMapper customVmMoviesTagsRealationMapper;
    @Autowired
    private VmMovieConfig movieConfig;
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
        if (1 != vmMoviesMapper.update(vmMoviesDto.getId(), vmMovies)) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesMapper#update is fail ! vmMovies is : " + vmMovies);
        }
        //get now obj
        vmMovies = this.getVmMoviesById(vmMoviesDto.getId(), BasePo.IsDeleted.NO);
        //delete old filmmaker realation
        int cnt = vmMoviesFilmmakersRealationMapper.batchUpdate(
                ImmutableMap.of(
                        "movieId", vmMovies.getId()
                ),
                ImmutableMap.of(
                        "isDeleted", BasePo.IsDeleted.YES.getCode()
                )
        );
        if (cnt < 0) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#deleteBy is fail ! vmMoviesDto is : " + vmMoviesDto);
        }


        //insert new filmmaker realation
        String actorIdsStr = vmMoviesDto.getActorIds();
        if (!isEmptyString(actorIdsStr)) {//without new realation
            List<Long> actorIds = parseStringArray2Long(actorIdsStr);
            List<VmMoviesFilmmakersRealation> vmMoviesFilmmakersRealations = makeVmMoviesFilmmakersRealations(vmMovies, actorIds);

            if (vmMoviesFilmmakersRealations.size() != vmMoviesFilmmakersRealationMapper.batchInsert(vmMoviesFilmmakersRealations)) {
                throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#batchInsert is fail ! vmMoviesFilmmakersRealations is : " + vmMoviesFilmmakersRealations);
            }
        }

        //delete old tag realation
        cnt = vmMoviesTagsRealationMapper.batchUpdate(
                ImmutableMap.of(
                        "movieId", vmMovies.getId()
                ), ImmutableMap.of(
                        "isDeleted", BasePo.IsDeleted.YES.getCode()
                ));
        if (cnt < 0) {
            throw new VmMoviesException("updateBackEndMoviesInfo vmTagsMapper#deleteBy is fail ! vmMoviesDto is : " + vmMoviesDto);
        }


        //insert new tag realation
        String tagIdsStr = vmMoviesDto.getTagIds();
        if (!isEmptyString(tagIdsStr)) {//without new realation
            List<Long> tagIds = parseStringArray2Long(tagIdsStr);
            List<VmMoviesTagsRealation> vmMoviesTagsRealations = makeVmMoviesTagsRealations(vmMovies, tagIds);

            if (vmMoviesTagsRealations.size() != vmMoviesTagsRealationMapper.batchInsert(vmMoviesTagsRealations)) {
                throw new VmMoviesException("updateBackEndMoviesInfo vmMoviesTagsRealationMapper#batchInsert is fail ! vmMoviesTagsRealations is : " + vmMoviesTagsRealations);
            }
        }


        return makeBackendMoviesDto(vmMovies);
    }

    private List<VmMoviesTagsRealation> makeVmMoviesTagsRealations(VmMovies vmMovies, List<Long> tagIds) {
        return tagIds.stream().parallel().map(tagId -> {
            return makeVmMoviesTagsRealation(vmMovies, tagId);
        }).collect(toList());
    }

    private VmMoviesTagsRealation makeVmMoviesTagsRealation(VmMovies vmMovies, Long tagId) {
        VmMoviesTagsRealation vmMoviesTagsRealation = new VmMoviesTagsRealation();
        Integer now = now();
        vmMoviesTagsRealation.setTagId(tagId);
        vmMoviesTagsRealation.setMovieId(vmMovies.getId());
        vmMoviesTagsRealation.setCreateTime(now);
        vmMoviesTagsRealation.setUpdateTime(now);
        vmMoviesTagsRealation.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmMoviesTagsRealation.setStatus(BasePo.Status.NORMAL.getCode());
        return vmMoviesTagsRealation;
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
        Response response = Response.fromJSON(res);
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
    @Transactional
    public VmMoviesDto updatePoster(UpdateHeadImgInfo updateHeadImgInfo) {
        //set versions
        updateHeadImgInfo.setVersions(movieConfig.getMoviePosterVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.fromJSON(res);
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

        //add filmmaker realation
        String actorIdsStr = vmMoviesDto.getActorIds();
        if (!isEmptyString(actorIdsStr)) {//without new realation
            List<Long> actorIds = parseStringArray2Long(actorIdsStr);

            List<VmMoviesFilmmakersRealation> vmMoviesFilmmakersRealations = makeVmMoviesFilmmakersRealations(vmMovies, actorIds);

            if (vmMoviesFilmmakersRealations.size() != vmMoviesFilmmakersRealationMapper.batchInsert(vmMoviesFilmmakersRealations)) {
                throw new VmMoviesException("addBackEndMoviesInfo vmMoviesFilmmakersRealationMapper#batchInsert is fail ! vmMoviesFilmmakersRealations is : " + vmMoviesFilmmakersRealations);
            }
        }

        //add tag realation
        String tagIdsStr = vmMoviesDto.getTagIds();
        if (!isEmptyString(tagIdsStr)) {//without new realation
            List<Long> tagIds = parseStringArray2Long(tagIdsStr);

            List<VmMoviesTagsRealation> vmMoviesTagsRealations = makeVmMoviesTagsRealations(vmMovies, tagIds);

            if (vmMoviesTagsRealations.size() != vmMoviesTagsRealationMapper.batchInsert(vmMoviesTagsRealations)) {
                throw new VmMoviesException("addBackEndMoviesInfo vmMoviesTagsRealationMapper#batchInsert is fail ! vmMoviesTagsRealations is : " + vmMoviesTagsRealations);
            }
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

    @Override
    public VmMovies getVmMoviesById(Long id, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmMoviesMapper, id, isDeleted);

    }

    @Override
    public void deleteMovies(VmMoviesDto vmMoviesDto) {
        int cnt = 0;
        String deletedIdsStr = vmMoviesDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmMoviesException("deleteMovies deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(vmMoviesDto.getDeletedIds());


        //delete movie tag realations
        List<Long> realationIds = customVmMoviesTagsRealationMapper.getRealationIdsByMovieIds(ImmutableMap.of(
                "movieIds", deletedIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode()

        ));
        if (!isEmptyList(realationIds)) {
            cnt = vmMoviesTagsRealationMapper.updateInIds(realationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != realationIds.size()) {
                throw new VmMoviesException("deleteMovies vmMoviesTagsRealationMapper#updateInIds is fail ! realationIds is : " + realationIds);
            }
        }
        //delete movie filmmaker realations
        realationIds = customVmMoviesFilmmakersRealationMapper.getRealationIdsByMovieIds(ImmutableMap.of(
                "movieIds", deletedIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode()

        ));
        if (!isEmptyList(realationIds)) {
            cnt = vmMoviesFilmmakersRealationMapper.updateInIds(realationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != realationIds.size()) {
                throw new VmMoviesException("deleteMovies vmMoviesFilmmakersRealationMapper#updateInIds is fail ! realationIds is : " + realationIds);
            }
        }
        //delete movie src versions
        List<Long> srcVersionIds = customVmMoviesSrcVersionMapper.getMovieSrcVersionIdsByMovieIds(ImmutableMap.of(
                "movieIds", deletedIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode()

        ));
        if (!isEmptyList(srcVersionIds)) {
            cnt = vmMoviesSrcVersionMapper.updateInIds(srcVersionIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != srcVersionIds.size()) {
                throw new VmMoviesException("deleteMovies vmMoviesSrcVersionMapper#updateInIds is fail ! srcVersionIds is : " + srcVersionIds);
            }
        }


        //delete movies
        if (!isEmptyList(deletedIds)) {
            cnt = vmMoviesMapper.updateInIds(deletedIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != deletedIds.size()) {
                throw new VmMoviesException("deleteMovies vmMoviesMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
            }
        }


    }

    @Override
    public VmMovies getVmMoviesById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {
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
