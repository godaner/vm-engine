package com.vm.admin.dao.mapper.custom;

import com.vm.admin.dao.po.VmAuthMenus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmAuthMenusMapper {

    List<VmAuthMenus> getMenusByIds(@Param("query") Object query);
}
