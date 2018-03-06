package com.vm.user.dao.mapper.custom;

import com.vm.base.util.BaseQueryBean;
import com.vm.base.util.PageBean;
import com.vm.user.dao.po.VmUsers;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.service.dto.VmUsersDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmUsersMapper {

    List<VmUsers> getUserList(@Param("query") VmUserQueryBean query, @Param("page") PageBean page);

    Long getUserListTotal(@Param("query") VmUserQueryBean query, @Param("page") PageBean page);
}