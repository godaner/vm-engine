package com.vm.dao.mapper;

import com.vm.dao.po.VmFilmmakers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmFilmmakersMapper {
    List<VmFilmmakers> selectActorsByMovieId(@Param("movieId") Long movieId);
    List<VmFilmmakers> selectActorsIdAndNameByMovieId(@Param("movieId") Long movieId);
    VmFilmmakers selectDirectorIdAndNameByDirectorId(@Param("directorId") Long directorId);
}