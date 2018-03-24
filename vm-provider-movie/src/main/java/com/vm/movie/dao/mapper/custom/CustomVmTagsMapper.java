package com.vm.movie.dao.mapper.custom;

import com.vm.movie.dao.po.VmTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmTagsMapper {


    List<VmTags> selectTagsIdAndNameByTagGroupId(@Param("tagGroupId") Long tagGroupId);

    List<VmTags> getTagsIdAndNameOfMovie(@Param("query") Object query);


    List<Long> getTagIdsByTagGroupIds(@Param("query") Object query);

}