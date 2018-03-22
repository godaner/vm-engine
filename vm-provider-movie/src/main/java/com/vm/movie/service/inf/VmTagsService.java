package com.vm.movie.service.inf;

import com.vm.dao.util.PageBean;
import com.vm.movie.dao.po.VmTags;
import com.vm.movie.dao.qo.VmTagGroupsQueryBean;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.dto.VmTagsGroupsDto;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagsService {

    List<VmTagsDto> getTags() throws Exception;

    List<VmTagsDto> getTagsByTagGroupId(Long tagGroupId);

    VmTagsDto addTag(VmTagsDto vmTagsDto);

    VmTagsDto editTag(VmTagsDto vmTagsDto);
}
