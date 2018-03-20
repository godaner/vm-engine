package com.vm.movie.dao.mapper.custom;

import com.vm.dao.util.PageBean;
import com.vm.movie.dao.po.VmFilmmakers;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.service.dto.VmFilmmakersDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmFilmmakersMapper {
    List<VmFilmmakers> selectActorsByMovieId(@Param("movieId") Long movieId);

    List<VmFilmmakers> selectActorsIdAndNameByMovieId(@Param("movieId") Long movieId);

    VmFilmmakers selectDirectorIdAndNameByDirectorId(@Param("directorId") Long directorId);

    List<VmFilmmakers> getFilmmakers(@Param("page") PageBean page, @Param("query") VmFilmmakerQueryBean query);

    Long getFilmmakersTotal(@Param("page") PageBean page, @Param("query") VmFilmmakerQueryBean query);

    List<Long> getActorIds(@Param("query") VmFilmmakerQueryBean query);
}