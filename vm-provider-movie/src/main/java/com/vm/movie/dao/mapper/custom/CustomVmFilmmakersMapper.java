package com.vm.movie.dao.mapper.custom;

import com.vm.movie.dao.po.VmFilmmakers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmFilmmakersMapper {
    List<VmFilmmakers> selectActorsByMovieId(@Param("movieId") Long movieId);
    List<VmFilmmakers> selectActorsIdAndNameByMovieId(@Param("movieId") Long movieId);
    VmFilmmakers selectDirectorIdAndNameByDirectorId(@Param("directorId") Long directorId);
}