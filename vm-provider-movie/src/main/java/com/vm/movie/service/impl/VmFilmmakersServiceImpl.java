package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vm.base.config.VmBaseConfig;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.BaseService;
import com.vm.base.util.BeanMapUtil;
import com.vm.base.util.Response;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.dao.mapper.VmFilmmakersMapper;
import com.vm.movie.dao.mapper.VmMoviesFilmmakersRealationMapper;
import com.vm.movie.dao.mapper.VmMoviesMapper;
import com.vm.movie.dao.mapper.custom.CustomVmFilmmakersMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesFilmmakersRealationMapper;
import com.vm.movie.dao.mapper.custom.CustomVmMoviesMapper;
import com.vm.movie.dao.po.VmFilmmakers;
import com.vm.movie.dao.po.VmMovies;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.feign.service.SrcServiceClient;
import com.vm.movie.service.dto.VmFilmmakersDto;
import com.vm.movie.service.exception.VmFilmmakersException;
import com.vm.movie.service.exception.VmMoviesException;
import com.vm.movie.service.inf.VmFilmmakersService;
import com.vm.movie.service.inf.VmMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/26.
 */
@Service
public class VmFilmmakersServiceImpl extends BaseService implements VmFilmmakersService {

    @Autowired
    private VmFilmmakersMapper vmFilmmakersMapper;

    @Autowired
    private VmMoviesMapper vmMoviesMapper;


    @Autowired
    private CustomVmMoviesMapper customVmMoviesMapper;

    @Autowired
    private CustomVmMoviesFilmmakersRealationMapper customVmMoviesFilmmakersRealationMapper;


    @Autowired
    private VmMoviesFilmmakersRealationMapper vmMoviesFilmmakersRealationMapper;

    @Autowired
    private CustomVmFilmmakersMapper customVmFilmmakersMapper;

    @Autowired
    private SrcServiceClient srcServiceClient;

    @Autowired
    private VmBaseConfig vmBaseConfig;

    @Autowired
    private VmMoviesService vmMoviesService;

    @Override
    public List<VmFilmmakersDto> getMovieFilmmakers(Long movieId) {

        VmMovies vmMovies = vmMoviesService.getVmMoviesById(movieId, BasePo.IsDeleted.NO);

        if (isNullObject(vmMovies)) {

            throw new VmMoviesException("getMovieFilmmakers vmMovies is not exist ! movieId is : " + movieId,
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
                    VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getMsg());
        }

        //返回集
        List<VmFilmmakers> filmmakers = Lists.newArrayList();

        //获取演员
        List<VmFilmmakers> actors = customVmFilmmakersMapper.selectActorsByMovieId(ImmutableMap.of(
                "movieId", movieId,
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "status", BasePo.Status.NORMAL.getCode()
        ));

        filmmakers.addAll(actors);
        //获取导演
        Long directorId = vmMovies.getDirectorId();
        if (!isNullObject(directorId)) {
            VmFilmmakers director = this.getFilmmakerById(directorId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
            if (!isNullObject(director)) {
                filmmakers.add(director);
            }
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


    private VmFilmmakersDto makeBasicFilmmakerDto(VmFilmmakers filmmaker) {
        VmFilmmakersDto vmFilmmakersDto = new VmFilmmakersDto();
        vmFilmmakersDto.setAlias(filmmaker.getAlias());
        vmFilmmakersDto.setBirthday(filmmaker.getBirthday());
        vmFilmmakersDto.setBloodType(filmmaker.getBloodType());
        vmFilmmakersDto.setCountry(filmmaker.getCountry());
        vmFilmmakersDto.setDescription(filmmaker.getDescription());
        vmFilmmakersDto.setId(filmmaker.getId());
        vmFilmmakersDto.setImgUrl(filmmaker.getImgUrl());
        vmFilmmakersDto.setProfession(filmmaker.getProfession());
        vmFilmmakersDto.setSex(filmmaker.getSex());
        vmFilmmakersDto.setName(filmmaker.getName());
        return vmFilmmakersDto;
    }


    @Override
    public VmFilmmakersDto getFilmmakerBasicInfo(Long filmmakerId) throws Exception {

        VmFilmmakers filmmaker = this.getFilmmakerById(filmmakerId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
        return filmmaker == null ? null : makeBasicFilmmakerDto(filmmaker);
    }

    private VmFilmmakers getFilmmakerById(Long filmmakerId, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmFilmmakersMapper, filmmakerId, isDeleted);
    }

    private VmFilmmakers getFilmmakerById(Long filmmakerId, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmFilmmakersMapper, filmmakerId, status, isDeleted);
    }

    @Override
    public List<VmFilmmakersDto> getFilmmakers(PageBean page, VmFilmmakerQueryBean query) {
        return customVmFilmmakersMapper.getFilmmakers(page, query).stream().parallel().map(vmFilmmakers -> {
            return makeBackendFilmmakerDto(vmFilmmakers);
        }).collect(toList());
    }

    private VmFilmmakersDto makeBackendFilmmakerDto(VmFilmmakers vmFilmmakers) {
        VmFilmmakersDto vmFilmmakersDto = new VmFilmmakersDto();
        vmFilmmakersDto.setAlias(vmFilmmakers.getAlias());
        vmFilmmakersDto.setBirthday(vmFilmmakers.getBirthday());
        vmFilmmakersDto.setBloodType(vmFilmmakers.getBloodType());
        vmFilmmakersDto.setCountry(vmFilmmakers.getCountry());
        vmFilmmakersDto.setDescription(vmFilmmakers.getDescription());
        vmFilmmakersDto.setId(vmFilmmakers.getId());
        vmFilmmakersDto.setImgUrl(vmFilmmakers.getImgUrl());
        vmFilmmakersDto.setProfession(vmFilmmakers.getProfession());
        vmFilmmakersDto.setSex(vmFilmmakers.getSex());
        vmFilmmakersDto.setName(vmFilmmakers.getName());
        vmFilmmakersDto.setUpdateTime(vmFilmmakers.getUpdateTime());
        vmFilmmakersDto.setCreateTime(vmFilmmakers.getCreateTime());
        vmFilmmakersDto.setStatus(vmFilmmakers.getStatus());
        return vmFilmmakersDto;
    }

    @Override
    public Long getFilmmakersTotal(PageBean page, VmFilmmakerQueryBean query) {
        return customVmFilmmakersMapper.getFilmmakersTotal(page, query);
    }

    @Override
    public VmFilmmakersDto addFilmmaker(VmFilmmakersDto vmFilmmakersDto) {

        VmFilmmakers vmFilmmakers = makeAddVmFilmmaker(vmFilmmakersDto);
        if (1 != vmFilmmakersMapper.insert(vmFilmmakers)) {
            throw new VmFilmmakersException("addFilmmaker vmFilmmakersMapper#insert is fail ! vmFilmmakersDto is : " + vmFilmmakersDto);
        }

        return makeBackendFilmmakerDto(this.getFilmmakerById(vmFilmmakers.getId(), BasePo.IsDeleted.NO));
    }

    @Override
    public VmFilmmakersDto editFilmmaker(VmFilmmakersDto vmFilmmakersDto) {

        VmFilmmakers vmFilmmakers = this.getFilmmakerById(vmFilmmakersDto.getId(), BasePo.IsDeleted.NO);
        if (isNullObject(vmFilmmakers)) {
            throw new VmFilmmakersException("editFilmmaker vmFilmmakers is not exits ! vmFilmmakersDto is : " + vmFilmmakersDto,
                    VmFilmmakersException.ErrorCode.FILMMAKER_IS_NOT_EXITS.getCode(),
                    VmFilmmakersException.ErrorCode.FILMMAKER_IS_NOT_EXITS.getMsg());
        }

        //update vmFilmmakers

        vmFilmmakers = makeUpdateFilmmaker(vmFilmmakersDto);

        if (1 != vmFilmmakersMapper.update(vmFilmmakers.getId(), vmFilmmakers)) {
            throw new VmFilmmakersException("editFilmmaker vmFilmmakersMapper#update is fail ! vmFilmmakersDto is : " + vmFilmmakersDto);
        }


        return makeBackendFilmmakerDto(this.getFilmmakerById(vmFilmmakers.getId(), BasePo.IsDeleted.NO));
    }

    @Override
    public VmFilmmakersDto updateImg(UpdateHeadImgInfo updateHeadImgInfo) {
        //set versions
        updateHeadImgInfo.setVersions(vmBaseConfig.getFilmmakerImgVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.fromJSON(res);
        if (response.isFailure()) {
            throw new VmMoviesException("updateImg srcServiceClient#cutUploadedImgFile is fail !! updateHeadImgInfo is :" + updateHeadImgInfo);
        }
        String imgUrl = (String) response.getData("imgUrl");
        //update user
        VmFilmmakers vmFilmmakers = new VmFilmmakers();
        vmFilmmakers.setId(updateHeadImgInfo.getId());
        vmFilmmakers.setImgUrl(imgUrl);
        vmFilmmakersMapper.update(vmFilmmakers.getId(), vmFilmmakers);


        //get new info
        vmFilmmakers = this.getFilmmakerById(vmFilmmakers.getId(), BasePo.IsDeleted.NO);

        return vmFilmmakers == null ? null : makeBackendFilmmakerDto(vmFilmmakers);
    }

    @Override
    @Transactional
    public void deleteFilmmaker(VmFilmmakersDto vmFilmmakersDto) {
        int cnt = 0;
        String deletedIdsStr = vmFilmmakersDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmFilmmakersException("deleteFilmmaker deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(vmFilmmakersDto.getDeletedIds());
        if (isEmptyList(deletedIds)) {
            throw new VmFilmmakersException("deleteFilmmaker deleteIds is empty ! deleteIds is : " + deletedIds);
        }


        //delete actors realations
        List<Long> willBeDeletedRealationIds = customVmMoviesFilmmakersRealationMapper.selectRealationIdsByfilmmakerIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "deletedIds", deletedIds
        ));
        if (!isEmptyList(willBeDeletedRealationIds)) {
            cnt = vmMoviesFilmmakersRealationMapper.updateInIds(willBeDeletedRealationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt < 0) {

                throw new VmFilmmakersException("deleteFilmmaker vmMoviesFilmmakersRealationMapper#updateInIds is fail ! willBeDeletedRealationIds is : " + willBeDeletedRealationIds);
            }
        }
        //delete direcot_id of vm_movie table
        cnt = customVmMoviesMapper.emptyDirectorIdByFilmmakerIds(ImmutableMap.of(
                "deletedIds", deletedIds
        ));
        if (cnt < 0) {
            throw new VmFilmmakersException("deleteFilmmaker customVmMoviesMapper#emptyDirectorIdByFilmmakerIds is fail ! deleteIds is : " + deletedIds);
        }

        //delete filmmakers
        cnt = vmFilmmakersMapper.updateInIds(deletedIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.YES.getCode()
        ));
        if (deletedIds.size() != cnt) {
            throw new VmFilmmakersException("deleteFilmmaker vmFilmmakersMapper#updateInIds is fail ! deleteIds is : " + deletedIds);
        }

    }

    @Override
    public List<Long> getActorIds(Long movieId) {
        VmFilmmakerQueryBean query = new VmFilmmakerQueryBean();
        query.setMovieId(movieId);
        return customVmFilmmakersMapper.getActorIds(query);
    }

    private VmFilmmakers makeUpdateFilmmaker(VmFilmmakersDto vmFilmmakersDto) {
        VmFilmmakers vmFilmmakers = new VmFilmmakers();
        Integer now = now();
        vmFilmmakers.setId(vmFilmmakersDto.getId());
        vmFilmmakers.setName(vmFilmmakersDto.getName());
        vmFilmmakers.setAlias(vmFilmmakersDto.getAlias());
        vmFilmmakers.setBirthday(vmFilmmakersDto.getBirthday());
        vmFilmmakers.setBloodType(vmFilmmakersDto.getBloodType());
        vmFilmmakers.setCountry(vmFilmmakersDto.getCountry());
        vmFilmmakers.setDescription(vmFilmmakersDto.getDescription());
        vmFilmmakers.setProfession(vmFilmmakersDto.getProfession());
        vmFilmmakers.setSex(vmFilmmakersDto.getSex());
        vmFilmmakers.setStatus(vmFilmmakersDto.getStatus());
        vmFilmmakers.setUpdateTime(now);
        return vmFilmmakers;
    }

    private VmFilmmakers makeAddVmFilmmaker(VmFilmmakersDto vmFilmmakersDto) {
        VmFilmmakers vmFilmmakers = new VmFilmmakers();
        Integer now = now();
        vmFilmmakers.setId(vmFilmmakersDto.getId());
        vmFilmmakers.setName(vmFilmmakersDto.getName());
        vmFilmmakers.setAlias(vmFilmmakersDto.getAlias());
        vmFilmmakers.setBirthday(vmFilmmakersDto.getBirthday());
        vmFilmmakers.setBloodType(vmFilmmakersDto.getBloodType());
        vmFilmmakers.setCountry(vmFilmmakersDto.getCountry());
        vmFilmmakers.setDescription(vmFilmmakersDto.getDescription());
        vmFilmmakers.setProfession(vmFilmmakersDto.getProfession());
        vmFilmmakers.setSex(vmFilmmakersDto.getSex());
        vmFilmmakers.setStatus(vmFilmmakersDto.getStatus());
        vmFilmmakers.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmFilmmakers.setCreateTime(now);
        vmFilmmakers.setUpdateTime(now);
        vmFilmmakers.setImgUrl(vmBaseConfig.getSrcImgDefaultUrl());
        return vmFilmmakers;
    }


}
