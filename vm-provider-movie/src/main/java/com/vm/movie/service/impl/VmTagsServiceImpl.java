package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.BaseService;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.dao.mapper.VmTagsGroupsMapper;
import com.vm.movie.dao.mapper.VmTagsMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsGroupsMapper;
import com.vm.movie.dao.po.VmTags;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.exception.VmTagsException;
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

    @Override
    public VmTagsDto addTag(VmTagsDto vmTagsDto) {

        VmTags vmTags = makeAddVmTag(vmTagsDto);

        if (1 != vmTagsMapper.insert(vmTags)) {
            throw new VmTagsException("addTag vmTagsMapper#insert is fail ! vmTagsDto is : " + vmTagsDto);
        }

        vmTags = this.getTagById(vmTags.getId(), BasePo.IsDeleted.NO);

        return makeBackendTagDto(vmTags);
    }

    @Override
    public VmTagsDto editTag(VmTagsDto vmTagsDto) {

        VmTags vmTags = this.getTagById(vmTagsDto.getId(), BasePo.IsDeleted.NO);
        if (isNullObject(vmTags)) {
            throw new VmTagsException("editTag vmTags is not exits ! vmTagsDto is : " + vmTagsDto);
        }

        vmTags = makeEditTag(vmTagsDto);
        if (1 != vmTagsMapper.update(vmTags.getId(), vmTags)) {
            throw new VmTagsException("editTag vmTagsMapper#update is fail ! vmTagsDto is : " + vmTagsDto);
        }

        vmTags = this.getTagById(vmTags.getId(), BasePo.IsDeleted.NO);
        return makeBackendTagDto(vmTags);
    }

    private VmTags makeEditTag(VmTagsDto vmTagsDto) {
        VmTags vmTags = new VmTags();
        Integer now = now();
        vmTags.setId(vmTagsDto.getId());
        vmTags.setStatus(vmTagsDto.getStatus());
        vmTags.setName(vmTagsDto.getName());
        vmTags.setUpdateTime(now);
        return vmTags;
    }

    private VmTags getTagById(Long id, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmTagsMapper, id, isDeleted);
    }

    private VmTags getTagById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmTagsMapper, id, status, isDeleted);
    }


    private VmTags makeAddVmTag(VmTagsDto vmTagsDto) {
        VmTags vmTags = new VmTags();
        Integer now = now();
        vmTags.setName(vmTagsDto.getName());
        vmTags.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmTags.setStatus(vmTagsDto.getStatus());
        vmTags.setTagGroupId(vmTagsDto.getTagGroupId());
        vmTags.setName(vmTagsDto.getName());
        vmTags.setCreateTime(now);
        vmTags.setUpdateTime(now);
        return vmTags;
    }


    private VmTagsDto makeBackendTagDto(VmTags vmTags) {
        VmTagsDto vmTagsDto = new VmTagsDto();
        vmTagsDto.setId(vmTags.getId());
        vmTagsDto.setName(vmTags.getName());
        vmTagsDto.setCreateTime(vmTags.getCreateTime());
        vmTagsDto.setUpdateTime(vmTags.getUpdateTime());
        vmTagsDto.setStatus(vmTags.getStatus());
        vmTagsDto.setTagGroupId(vmTags.getTagGroupId());
        return vmTagsDto;
    }


}
