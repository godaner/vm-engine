package com.vm.movie.service.inf;

import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.dto.VmTagsGroupsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagsService {
    List<VmTagsGroupsDto> getTagsGroupsWithTags() throws Exception;

    List<VmTagsDto> getTags() throws Exception;

}
