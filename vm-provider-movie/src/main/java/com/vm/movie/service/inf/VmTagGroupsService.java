package com.vm.movie.service.inf;

import com.vm.dao.util.PageBean;
import com.vm.movie.dao.qo.VmTagGroupsQueryBean;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.dto.VmTagsGroupsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagGroupsService {
    List<VmTagsGroupsDto> getAllTagsGroupsWithTags() throws Exception;

    List<VmTagsGroupsDto> getTagGroups(VmTagGroupsQueryBean query, PageBean page);

    Long getTagGroupsTotal(VmTagGroupsQueryBean query, PageBean page);

    VmTagsGroupsDto editTagGroup(VmTagsGroupsDto vmTagsGroupsDto);

    VmTagsGroupsDto addTagGroup(VmTagsGroupsDto vmTagsGroupsDto);

    void deleteTagGroups(VmTagsGroupsDto vmTagsGroupsDto);

    List<VmTagsGroupsDto> getBackendAllTagsGroupsWithTags();
}
