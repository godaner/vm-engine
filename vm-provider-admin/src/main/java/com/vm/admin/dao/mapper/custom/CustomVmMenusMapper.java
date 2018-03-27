package com.vm.admin.dao.mapper.custom;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.po.VmMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmMenusMapper {


    List<Long> getMenuParentIdsByMenuIds(@Param("query") Object query);
}
