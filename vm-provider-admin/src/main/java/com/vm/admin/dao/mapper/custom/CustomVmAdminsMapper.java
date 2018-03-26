package com.vm.admin.dao.mapper.custom;

import com.vm.admin.dao.po.VmAdmins;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.dao.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public interface CustomVmAdminsMapper {
    List<VmAdmins> getAdmins(@Param("page") PageBean page, @Param("query") VmAdminsQueryBean query);

    Long getAdminsTotal(@Param("page") PageBean page, @Param("query") VmAdminsQueryBean query);
}
