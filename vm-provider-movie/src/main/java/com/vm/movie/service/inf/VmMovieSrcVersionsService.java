package com.vm.movie.service.inf;

import com.vm.movie.service.dto.VmMoviesSrcVersionDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/24.
 */
public interface VmMovieSrcVersionsService {


    List<VmMoviesSrcVersionDto> getMovieSrcVersions(Long movieId) throws Exception;

    void uploadVideo(VmMoviesSrcVersionDto vmMoviesSrcVersionDto);
}
