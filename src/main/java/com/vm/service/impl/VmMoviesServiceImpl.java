package com.vm.service.impl;

import com.google.common.collect.Maps;
import com.vm.dao.mapper.*;
import com.vm.dao.po.*;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmMoviesService;
import com.vm.utils.VmProperties;
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
    public List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query) {

        if (isEmptyList(query.getTagIds())) {
            query.setTagIdsLength(0);
        } else {
            query.setTagIdsLength(query.getTagIds().size());
        }
        return customVmMoviesMapper.getMovies(page, query);
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
    public List<VmTags> getTagsOfMovie(Long movieId) throws Exception {
        return customVmTagsMapper.getTagsOfMovie(movieId);
    }

    @Override
    public List<VmFilmmakers> getMovieFilmmakers(Long movieId) {

        VmMovies vmMovies = validateMovie(movieId);
        eject(isNullObject(vmMovies),
                "getMovieFilmmakers vmMovies is not exist ! movieId is :" + movieId);
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

        //去除重复的电影人
        return takeOffSameFilmmakers(filmmakers);
    }

    /**
     * 去除list的重复filmmaker
     *
     * @param filmmakers
     * @return
     */
    private List<VmFilmmakers> takeOffSameFilmmakers(List<VmFilmmakers> filmmakers) {
        if (isEmptyList(filmmakers)) {
            return Lists.newArrayList();
        }
        Map<Long, VmFilmmakers> map = Maps.newHashMap();
        for (VmFilmmakers filmmaker : filmmakers) {
            map.put(filmmaker.getId(), filmmaker);
        }
        return Lists.newArrayList(map.values());
    }

    @Override
    public List<VmMoviesSrcVersion> getMovieSrcVersions(Long movieId) throws Exception {

        VmMovies vmMovies = validateMovie(movieId);
        eject(isNullObject(vmMovies),
                "getMovieFilmmakers vmMovies is not exist ! movieId is :" + movieId);

        return customVmMoviesSrcVersionMapper.selectMovieSrcVersionsByMovieId(movieId);
    }

    @Override
    public String getMoviePosterUrl(Long movieId) throws Exception {
        VmMovies vmMovies = validateMovie(movieId);

        eject(isNullObject(vmMovies),
                "getMovieFilmmakers vmMovies is not exist ! movieId is :" + movieId);

        return vmMovies.getPosterUrl();
    }


    @Override
    public List<VmMovies> getAboutTagsMovies(PageBean page, VmMoviesQueryBean query) throws Exception {
        return customVmMoviesMapper.getAboutTagsMovies(page, query);
    }

    @Override
    public List<VmMovies> getAboutFilmmakersMovies(PageBean page, VmMoviesQueryBean query) {
        return customVmMoviesMapper.getAboutFilmmakersMovies(page, query);
    }


    @Override
    public CustomVmMovies getMovie(Long movieId) {
        eject(movieId == null, "VmMoviesService#getMovie movieId is null ! movieId is :" + movieId);

        return customVmMoviesMapper.getMovie(movieId);
    }

    @Override
    public void sendMovieImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
            String movieImgPath = VmProperties.VM_MOVIE_IMG_PATH;
            String width = query.getImgWidth();
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
