package com.vm.frontend.service.impl;

import com.vm.base.utils.BaseService;
import com.vm.frontend.service.dto.VmTagsDto;
import com.vm.frontend.service.dto.VmTagsGroupsDto;
import com.vm.frontend.service.inf.VmTagsService;
import com.vm.dao.mapper.CustomVmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.custom.CustomVmTagsGroups;
import com.vm.dao.po.VmTags;
import com.vm.dao.po.VmTagsExample;
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
        VmTagsExample vmTagsExample = new VmTagsExample();
        VmTagsExample.Criteria criteria = vmTagsExample.createCriteria();
        criteria.andStatusEqualTo(BasePo.Status.NORMAL.getCode());
        return vmTagsMapper.selectByExample(vmTagsExample).stream().map((tag) -> {
            VmTagsDto vmTagsBo = new VmTagsDto();
            vmTagsBo.setId(tag.getId());
            vmTagsBo.setName(tag.getName());
            return vmTagsBo;
        }).collect(toList());
    }


}
