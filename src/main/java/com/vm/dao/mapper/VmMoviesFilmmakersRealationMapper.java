package com.vm.dao.mapper;

import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.po.VmMoviesFilmmakersRealation;
import com.vm.dao.po.VmMoviesFilmmakersRealationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmMoviesFilmmakersRealationMapper {
    long countByExample(VmMoviesFilmmakersRealationExample example);

    int deleteByExample(VmMoviesFilmmakersRealationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmMoviesFilmmakersRealation record);

    int insertSelective(VmMoviesFilmmakersRealation record);

    List<VmMoviesFilmmakersRealation> selectByExample(VmMoviesFilmmakersRealationExample example);

    VmMoviesFilmmakersRealation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmMoviesFilmmakersRealation record, @Param("example") VmMoviesFilmmakersRealationExample example);

    int updateByExample(@Param("record") VmMoviesFilmmakersRealation record, @Param("example") VmMoviesFilmmakersRealationExample example);

    int updateByPrimaryKeySelective(VmMoviesFilmmakersRealation record);

    int updateByPrimaryKey(VmMoviesFilmmakersRealation record);


}