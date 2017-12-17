package com.vm.service.impl;

import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.dao.mapper.VmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsMapper;
import com.vm.service.BaseService;
import com.vm.service.inf.VmTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
@Service
public class VmTagsServiceImpl  extends BaseService implements VmTagsService {
    @Autowired
    private VmTagsMapper vmTagsMapper;
    @Autowired
    private VmTagsGroupsMapper vmTagsGroupsMapper;
    @Override
    public List<CustomVmTagsGroups> getTagsGroupsWithTags() {
        return vmTagsGroupsMapper.getTagsGroupsWithTags();
    }
}
