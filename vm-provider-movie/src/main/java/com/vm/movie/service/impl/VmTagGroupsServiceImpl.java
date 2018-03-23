package com.vm.movie.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.BaseService;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.movie.dao.mapper.VmTagsGroupsMapper;
import com.vm.movie.dao.mapper.VmTagsMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsGroupsMapper;
import com.vm.movie.dao.mapper.custom.CustomVmTagsMapper;
import com.vm.movie.dao.po.VmTagsGroups;
import com.vm.movie.dao.qo.VmTagGroupsQueryBean;
import com.vm.movie.service.dto.VmTagsGroupsDto;
import com.vm.movie.service.exception.VmFilmmakersException;
import com.vm.movie.service.exception.VmTagGroupsException;
import com.vm.movie.service.inf.VmTagGroupsService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/11.
 */
@Service
public class VmTagGroupsServiceImpl extends BaseService implements VmTagGroupsService {
    @Autowired
    private VmTagsMapper vmTagsMapper;
    @Autowired
    private CustomVmTagsMapper customVmTagsMapper;
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
    public List<VmTagsGroupsDto> getTagGroups(VmTagGroupsQueryBean query, PageBean page) {
        return customVmTagsGroupsMapper.getTagGroups(query, page).stream().parallel().map(vmTagsGroups -> {
            return makeBackendTagGroupDto(vmTagsGroups);
        }).collect(toList());
    }

    @Override
    public Long getTagGroupsTotal(VmTagGroupsQueryBean query, PageBean page) {
        return customVmTagsGroupsMapper.getTagGroupsTotal(query, page);
    }

    @Override
    public VmTagsGroupsDto editTagGroup(VmTagsGroupsDto vmTagsGroupsDto) {
        VmTagsGroups vmTagsGroups = this.getTagGroupById(vmTagsGroupsDto.getId(), BasePo.IsDeleted.NO);

        // exits ?
        if (isNullObject(vmTagsGroups)) {
            throw new VmTagGroupsException("editTagGroup tag group is not exits ! vmTagsGroupsDto is : " + vmTagsGroupsDto,
                    VmTagGroupsException.ErrorCode.TAG_GROUP_IS_NOT_EXITS.getCode(),
                    VmTagGroupsException.ErrorCode.TAG_GROUP_IS_NOT_EXITS.getMsg());
        }
        //have same name ?
        if (!vmTagsGroupsDto.getName().equals(vmTagsGroups.getName())) {
            vmTagsGroups = vmTagsGroupsMapper.selectOneBy(ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "name", vmTagsGroupsDto.getName()
            ));
            if (!isNullObject(vmTagsGroups)) {
                throw new VmTagGroupsException("editTagGroup tag group name is exits ! vmTagsGroupsDto is : " + vmTagsGroupsDto,
                        VmTagGroupsException.ErrorCode.TAG_GROUP_NAME_IS_EXITS.getCode(),
                        VmTagGroupsException.ErrorCode.TAG_GROUP_NAME_IS_EXITS.getMsg());
            }

        }

        //update
        vmTagsGroups = makeEditTagGroup(vmTagsGroupsDto);
        if (1 != vmTagsGroupsMapper.update(vmTagsGroups.getId(), vmTagsGroups)) {
            throw new VmTagGroupsException("editTagGroup vmTagsGroupsMapper#update is fail ! vmTagsGroupsDto is : " + vmTagsGroupsDto);
        }
        vmTagsGroups = this.getTagGroupById(vmTagsGroups.getId(), BasePo.IsDeleted.NO);
        return makeBackendTagGroupDto(vmTagsGroups);
    }


    @Override
    public VmTagsGroupsDto addTagGroup(VmTagsGroupsDto vmTagsGroupsDto) {
        VmTagsGroups vmTagsGroups = vmTagsGroupsMapper.selectOneBy(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "name", vmTagsGroupsDto.getName()
        ));
        if (!isNullObject(vmTagsGroups)) {
            throw new VmTagGroupsException("addTagGroup tag group name is exits ! vmTagsGroupsDto is : " + vmTagsGroupsDto,
                    VmTagGroupsException.ErrorCode.TAG_GROUP_NAME_IS_EXITS.getCode(),
                    VmTagGroupsException.ErrorCode.TAG_GROUP_NAME_IS_EXITS.getMsg());
        }

        vmTagsGroups = makeAddTagGroup(vmTagsGroupsDto);
        if (1 != vmTagsGroupsMapper.insert(vmTagsGroups)) {
            throw new VmTagGroupsException("addTagGroup vmTagsGroupsMapper#insert is fail ! vmTagsGroupsDto is : " + vmTagsGroupsDto);
        }
        vmTagsGroups = this.getTagGroupById(vmTagsGroups.getId(), BasePo.IsDeleted.NO);
        return makeBackendTagGroupDto(vmTagsGroups);
    }

    @Override
    @Transactional
    public void deleteTagGroups(VmTagsGroupsDto vmTagsGroupsDto) {
        int cnt = 0;
        String deletedIdsStr = vmTagsGroupsDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmFilmmakersException("deleteTagGroups deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(vmTagsGroupsDto.getDeletedIds());

        //delete tags
        List<Long> willBeDeletedTagIds = customVmTagsMapper.getTagIdsByTagGroupIds(ImmutableMap.of(
                "tagGroupIds", deletedIds,
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
        if (!isEmptyList(willBeDeletedTagIds)) {
            cnt = vmTagsMapper.updateInIds(willBeDeletedTagIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (cnt != willBeDeletedTagIds.size()) {
                throw new VmFilmmakersException("deleteTagGroups vmTagsMapper#updateInIds is fail ! willBeDeletedTagIds is : " + willBeDeletedTagIds);
            }
        }


        //delete tag group
        cnt = vmTagsGroupsMapper.updateInIds(deletedIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.YES.getCode()
        ));
        if (cnt != deletedIds.size()) {
            throw new VmFilmmakersException("deleteTagGroups vmTagsGroupsMapper#updateInIds is fail ! deleteIds is : " + deletedIds);
        }

    }

    private VmTagsGroups makeAddTagGroup(VmTagsGroupsDto vmTagsGroupsDto) {
        VmTagsGroups vmTagsGroups = new VmTagsGroups();
        Integer now = now();
        vmTagsGroups.setName(vmTagsGroupsDto.getName());
        vmTagsGroups.setId(vmTagsGroupsDto.getId());
        vmTagsGroups.setStatus(vmTagsGroupsDto.getStatus());
        vmTagsGroups.setUpdateTime(now);
        vmTagsGroups.setCreateTime(now);
        vmTagsGroups.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        return vmTagsGroups;
    }

    private VmTagsGroups makeEditTagGroup(VmTagsGroupsDto vmTagsGroupsDto) {
        VmTagsGroups vmTagsGroups = new VmTagsGroups();
        Integer now = now();
        vmTagsGroups.setName(vmTagsGroupsDto.getName());
        vmTagsGroups.setId(vmTagsGroupsDto.getId());
        vmTagsGroups.setStatus(vmTagsGroupsDto.getStatus());
        vmTagsGroups.setUpdateTime(now);
        return vmTagsGroups;
    }

    private VmTagsGroups getTagGroupById(Long id, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmTagsGroupsMapper, id, isDeleted);
    }

    private VmTagsGroups getTagGroupById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        return QuickSelectOne.getObjectById(vmTagsGroupsMapper, id, status, isDeleted);
    }


    private VmTagsGroupsDto makeBackendTagGroupDto(VmTagsGroups vmTagsGroups) {
        VmTagsGroupsDto vmTagsGroupsDto = new VmTagsGroupsDto();
        vmTagsGroupsDto.setId(vmTagsGroups.getId());
        vmTagsGroupsDto.setName(vmTagsGroups.getName());
        vmTagsGroupsDto.setCreateTime(vmTagsGroups.getCreateTime());
        vmTagsGroupsDto.setUpdateTime(vmTagsGroups.getUpdateTime());
        vmTagsGroupsDto.setStatus(vmTagsGroups.getStatus());
        return vmTagsGroupsDto;
    }


}
