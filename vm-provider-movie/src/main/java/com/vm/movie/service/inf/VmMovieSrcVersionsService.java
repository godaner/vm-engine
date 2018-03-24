package com.vm.movie.service.inf;

import com.vm.dao.util.BasePo;
import com.vm.movie.dao.po.VmMoviesSrcVersion;
import com.vm.movie.service.dto.VmMoviesSrcVersionDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/24.
 */
public interface VmMovieSrcVersionsService {


    List<VmMoviesSrcVersionDto> getMovieSrcVersions(Long movieId) throws Exception;

    VmMoviesSrcVersionDto uploadVideo(VmMoviesSrcVersionDto vmMoviesSrcVersionDto);

    VmMoviesSrcVersion getVmMovieSrcVersionById(Long id, BasePo.IsDeleted isDeleted);

    VmMoviesSrcVersion getVmMovieSrcVersionById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted);

    List<VmMoviesSrcVersionDto> getAllVersionsByMovieId(Long movieId);
}
