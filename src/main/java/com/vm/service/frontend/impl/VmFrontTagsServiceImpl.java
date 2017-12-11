package com.vm.service.frontend.impl;

import com.vm.base.bo.VmTagsGroupsWithTagsList;
import com.vm.mapper.CustomVmTagsGroupsMapper;
import com.vm.mapper.VmTagsMapper;
import com.vm.service.frontend.VmFrontEndTagsService;
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
        return customVmTagsGroupsMapper.getTagsGroupsWithTags();
    }
}
