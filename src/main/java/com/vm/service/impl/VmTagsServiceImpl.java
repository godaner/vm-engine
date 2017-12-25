package com.vm.service.impl;

import com.vm.dao.mapper.CustomVmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsGroupsMapper;
import com.vm.dao.mapper.VmTagsMapper;
import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.dao.po.VmTags;
import com.vm.dao.po.VmTagsExample;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CustomVmTagsGroups> getTagsGroupsWithTags() {
        return customVmTagsGroupsMapper.getTagsGroupsWithTags();
    }

    @Override
    public List<VmTags> getTags() throws Exception {
        VmTagsExample vmTagsExample = new VmTagsExample();
        VmTagsExample.Criteria criteria = vmTagsExample.createCriteria();
        criteria.andStatusEqualTo(VmTags.Status.NORMAL.getCode());
        return vmTagsMapper.selectByExample(vmTagsExample);
    }


}
