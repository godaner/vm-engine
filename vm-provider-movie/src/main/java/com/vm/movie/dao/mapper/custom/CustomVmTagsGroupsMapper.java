package com.vm.movie.dao.mapper.custom;

import com.vm.dao.util.PageBean;
import com.vm.movie.dao.po.VmTagsGroups;
import com.vm.movie.dao.po.custom.CustomVmTagsGroups;
import com.vm.movie.dao.qo.VmTagGroupsQueryBean;
import com.vm.movie.service.dto.VmTagsGroupsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmTagsGroupsMapper {

    List<CustomVmTagsGroups> getAllTagsGroupsWithTags(@Param("query") Object query);

    List<VmTagsGroups> getTagGroups(@Param("query") VmTagGroupsQueryBean query, @Param("page") PageBean page);

    Long getTagGroupsTotal(@Param("query") VmTagGroupsQueryBean query, @Param("page") PageBean page);
}