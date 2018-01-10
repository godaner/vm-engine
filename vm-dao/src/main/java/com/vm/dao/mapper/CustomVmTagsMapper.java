package com.vm.dao.mapper;

import com.vm.dao.po.VmTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmTagsMapper {


    List<VmTags> selectTagsIdAndNameByTagGroupId(@Param("tagGroupId") Long tagGroupId);

    List<VmTags> getTagsIdAndNameOfMovie(@Param("movieId") Long movieId);


}