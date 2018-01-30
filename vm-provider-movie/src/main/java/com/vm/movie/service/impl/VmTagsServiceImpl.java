package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.BaseService;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.dto.VmTagsGroupsDto;
import com.vm.movie.service.inf.VmTagsService;
import com.vm.dao.mapper.custom.CustomVmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsMapper;
import com.vm.dao.po.BasePo;
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
    public List<VmTagsGroupsDto> getTagsGroupsWithTags() {
        return customVmTagsGroupsMapper.getTagsGroupsWithTags().stream().map((tagGroup) -> {
            VmTagsGroupsDto vmTagsGroupsDto = new VmTagsGroupsDto();
            vmTagsGroupsDto.setId(tagGroup.getId());
            vmTagsGroupsDto.setName(tagGroup.getName());
            vmTagsGroupsDto.setItems(tagGroup.getItems());
            return vmTagsGroupsDto;
        }).collect(toList());
    }

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


}