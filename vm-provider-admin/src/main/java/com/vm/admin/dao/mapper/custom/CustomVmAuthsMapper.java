package com.vm.admin.dao.mapper.custom;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmAuthsMapper {

    List<String> getAuthCodesByAuthIds(@Param("query") Object query);
}
