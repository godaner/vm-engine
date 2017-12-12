package com.vm.service.impl;

import com.google.common.collect.Lists;
import com.vm.dao.bo.VmTagsGroupsWithTagsList;
import com.vm.dao.mapper.CustomVmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsMapper;
import com.vm.dao.po.VmTags;
import com.vm.service.VmFrontEndTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
@Service
public class VmFrontTagsServiceImpl implements VmFrontEndTagsService {
    @Autowired
    private VmTagsMapper vmTagsMapper;
    @Autowired
    private CustomVmTagsGroupsMapper customVmTagsGroupsMapper;
    @Override
    public List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags() {
        VmTags vmTags = vmTagsMapper.selectByPrimaryKey(1l);
        return Lists.newArrayListWithCapacity(10);
    }
}
