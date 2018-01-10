package com.vm.frontend.service.impl;

import com.google.common.collect.Maps;
import com.vm.base.utils.BaseService;
import com.vm.base.utils.VmProperties;
import com.vm.dao.mapper.*;
import com.vm.dao.po.*;
import com.vm.dao.po.custom.CustomVmMovies;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.frontend.service.dto.VmFilmmakersDto;
import com.vm.frontend.service.dto.VmMoviesDto;
import com.vm.frontend.service.dto.VmMoviesSrcVersionDto;
import com.vm.frontend.service.dto.VmTagsDto;
import com.vm.frontend.service.exception.VmMoviesException;
import com.vm.frontend.service.inf.VmMoviesService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
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
    private VmFilesMapper vmFilesMapper;
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

    /**
     * 构建含有基本电影信息的dto
     *
     * @param customVmMovies
     * @return
     */
    private VmMoviesDto makeBasicMovieDto(CustomVmMovies customVmMovies) {
        VmMoviesDto vmMoviesDto = new VmMoviesDto();
        vmMoviesDto.setDescription(customVmMovies.getAlias());
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
        return vmMoviesDto;
    }

    /**
     * 构建含有actors和director的dto集合
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

    /**
     * 验证movie是否存在
     *
     * @param movieId
     * @return
     */
    private VmMovies validateMovie(Long movieId) {
        //获取电影
        VmMovies vmMovies = vmMoviesMapper.selectByPrimaryKey(movieId);
        if (vmMovies == null || BasePo.Status.isDeleted(vmMovies.getStatus())) {
            return null;
        } else {
            return vmMovies;
        }

    }

    @Override
    public List<VmMoviesDto> getMovies(PageBean page, VmMoviesQueryBean query) {

        if (isEmptyList(query.getTagIds())) {
            query.setTagIdsLength(0);
        } else {
            query.setTagIdsLength(query.getTagIds().size());
        }
        return makeGetMoviesVmMoviesBos(customVmMoviesMapper.getMovies(page, query));
    }

    private List<VmMoviesDto> makeGetMoviesVmMoviesBos(List<CustomVmMovies> movies) {
        return movies.stream().map((movie) -> {
            VmMoviesDto vmMoviesBo = new VmMoviesDto();
            vmMoviesBo.setDescription(movie.getAlias());
            vmMoviesBo.setDirectorId(movie.getDirectorId());
            vmMoviesBo.setId(movie.getId());
            vmMoviesBo.setImgUrl(movie.getImgUrl());
            vmMoviesBo.setMovieTime(movie.getMovieTime());
            vmMoviesBo.setName(movie.getName());
            vmMoviesBo.setPosterUrl(movie.getPosterUrl());
            vmMoviesBo.setReleaseTime(movie.getReleaseTime());
            vmMoviesBo.setScore(movie.getScore());
            vmMoviesBo.setWatchNum(movie.getWatchNum());
            vmMoviesBo.setReleaseTime(movie.getReleaseTime());
            vmMoviesBo.setDirector(movie.getDirector());
            vmMoviesBo.setActors(movie.getActors());
            return vmMoviesBo;
        }).collect(toList());
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
        return makeTagsBos(customVmTagsMapper.getTagsOfMovie(movieId));
    }

    private List<VmTagsDto> makeTagsBos(List<VmTags> tagsOfMovie) {
        return tagsOfMovie.stream().map((tag) -> {
            VmTagsDto vmTagsBo = new VmTagsDto();
            vmTagsBo.setId(tag.getId());
            vmTagsBo.setName(tag.getName());
            return vmTagsBo;
        }).collect(toList());
    }

    @Override
    public List<VmFilmmakersDto> getMovieFilmmakers(Long movieId) {

        VmMovies vmMovies = validateMovie(movieId);


        if (isNullObject(vmMovies)) {
            logger.error("getMovieFilmmakers vmMovies is not exist ! movieId is : {}", movieId);
            throw new VmMoviesException(VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
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
            VmFilmmakers director = vmFilmmakersMapper.selectByPrimaryKey(directorId);
            filmmakers.add(director);
        }

        return makeFilmmakerBos(filmmakers);
    }


    private List<VmFilmmakersDto> makeFilmmakerBos(List<VmFilmmakers> filmmakers) {
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

        VmMovies vmMovies = validateMovie(movieId);

        if (isNullObject(vmMovies)) {
            logger.error("getMovieFilmmakers vmMovies is not exist ! movieId is : {}", movieId);
            throw new VmMoviesException(VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
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
        VmMovies vmMovies = validateMovie(movieId);

        if (isNullObject(vmMovies)) {
            logger.error("getMovieFilmmakers vmMovies is not exist ! movieId is : {}", movieId);
            throw new VmMoviesException(VmMoviesException.ErrorCode.MOVIE_IS_NOT_EXITS.getCode(),
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
    public VmMoviesDto getMovie(Long movieId) {

        return makeBasicMovieDto(customVmMoviesMapper.getMovie(movieId));
    }


    @Override
    public void sendMovieImg(Long fileId, Integer width, HttpServletResponse response) throws Exception {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
            String movieImgPath = VmProperties.VM_MOVIE_IMG_PATH;
            String movieImgName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieImgName = file.getFilename();
            }
            File f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(movieImgPath + File.separator + VmProperties.VM_MOVIE_IMG_DEFAULT_NAME);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
// ");
            response.setContentType(contentType); // 设置返回的文件类型
            IOUtils.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }

    @Override
    public void sendMovieSrc(Long fileId, HttpServletResponse response) throws Exception {

        InputStream input = null;
        OutputStream output = null;
        try {
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
            String movieSrcPath = VmProperties.VM_MOVIE_SRC_PATH;

            String movieSrcName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieSrcName = file.getFilename();
            }
            File f = new File(movieSrcPath + File.separator + movieSrcName);
            //不存在，返回默认图片
            if (!f.exists()) {
                movieSrcName = VmProperties.VM_MOVIE_SRC_DEFAULT_NAME;
                f = new File(movieSrcPath + File.separator + movieSrcName);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
            response.setContentType(contentType); // 设置返回的文件类型

//            IOUtils.copy(input, output);

            limitedWriter(response.getOutputStream(), input, 1024 * 1024l, System.currentTimeMillis(), MessageDigest.getInstance("MD5"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }


}
