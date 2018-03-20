package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.BaseService;
import com.vm.dao.util.BasePo;
import com.vm.movie.dao.mapper.VmTagsGroupsMapper;
import com.vm.movie.dao.mapper.VmTagsMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsGroupsMapper;
import com.vm.movie.dao.po.VmTags;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.inf.VmTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/11.
 */
@Service
public class VmTagsServiceImpl extends BaseService implements VmTagsService {
    @Autowired
    private VmTagsMapper vmTagsMapper;
    @Autowired
    private VmTagsGroupsMapper vmTagsGroupsMapper;
    @Autowired
    private CustomVmTagsGroupsMapper customVmTagsGroupsMapper;


    @Override
    public List<VmTagsDto> getTags() throws Exception {

        return vmTagsMapper.selectBy(ImmutableMap.of(
                "status", BasePo.Status.NORMAL.getCode())
        ).stream().map((tag) -> {
            VmTagsDto vmTagsBo = new VmTagsDto();
            vmTagsBo.setId(tag.getId());
            vmTagsBo.setName(tag.getName());
            return vmTagsBo;
        }).collect(toList());
    }


    @Override
    public List<VmTagsDto> getTagsByTagGroupId(Long tagGroupId) {
        return vmTagsMapper.selectBy(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "tagGroupId", tagGroupId
        )).stream().parallel().map(vmTags -> {
            return makeBackendTagDto(vmTags);
        }).collect(toList());
    }

    private VmTagsDto makeBackendTagDto(VmTags vmTags) {
        VmTagsDto vmTagsDto = new VmTagsDto();
        vmTagsDto.setId(vmTags.getId());
        vmTagsDto.setName(vmTags.getName());
        vmTagsDto.setCreateTime(vmTags.getCreateTime());
        vmTagsDto.setUpdateTime(vmTags.getUpdateTime());
        vmTagsDto.setStatus(vmTags.getStatus());
        return vmTagsDto;
    }


}
