package com.vm.user.dao.mapper.custom;

import com.vm.dao.util.PageBean;
import com.vm.user.dao.po.VmUsers;
import com.vm.user.dao.po.custom.CustomVmUsersLoginAreaCount;
import com.vm.user.dao.po.custom.CustomVmUsersSexCount;
import com.vm.user.dao.qo.VmUserQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmUsersMapper {

    List<VmUsers> getUserList(@Param("query") VmUserQueryBean query, @Param("page") PageBean page);

    Long getUserListTotal(@Param("query") VmUserQueryBean query, @Param("page") PageBean page);

    List<CustomVmUsersSexCount> countUserSex(@Param("query") Object query);

}