package com.vm.admin.dao.mapper.custom;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.po.VmAuthMenus;
import com.vm.admin.dao.po.VmAuths;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmAuthsMapper {

    List<VmAuths> getAuthsByIds(@Param("query") Object query);
}
