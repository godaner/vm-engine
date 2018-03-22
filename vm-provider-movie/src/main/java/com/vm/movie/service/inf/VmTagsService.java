package com.vm.movie.service.inf;

import com.vm.movie.service.dto.VmTagsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagsService {

    List<VmTagsDto> getTags() throws Exception;

    List<VmTagsDto> getTagsByTagGroupId(Long tagGroupId);

    VmTagsDto addTag(VmTagsDto vmTagsDto);

    VmTagsDto editTag(VmTagsDto vmTagsDto);

    void deleteTags(VmTagsDto vmTagsDto);
}
