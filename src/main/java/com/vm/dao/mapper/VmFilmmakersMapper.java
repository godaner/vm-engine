package com.vm.dao.mapper;

import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.po.VmFilmmakersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmFilmmakersMapper {
    long countByExample(VmFilmmakersExample example);

    int deleteByExample(VmFilmmakersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmFilmmakers record);

    int insertSelective(VmFilmmakers record);

    List<VmFilmmakers> selectByExample(VmFilmmakersExample example);

    VmFilmmakers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmFilmmakers record, @Param("example") VmFilmmakersExample example);

    int updateByExample(@Param("record") VmFilmmakers record, @Param("example") VmFilmmakersExample example);

    int updateByPrimaryKeySelective(VmFilmmakers record);

    int updateByPrimaryKey(VmFilmmakers record);

}