package com.vm.mapper;

import com.vm.base.po.VmUsers;
import com.vm.base.po.VmUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmUsersMapper {
    long countByExample(VmUsersExample example);

    int deleteByExample(VmUsersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmUsers record);

    int insertSelective(VmUsers record);

    List<VmUsers> selectByExample(VmUsersExample example);

    VmUsers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmUsers record, @Param("example") VmUsersExample example);

    int updateByExample(@Param("record") VmUsers record, @Param("example") VmUsersExample example);

    int updateByPrimaryKeySelective(VmUsers record);

    int updateByPrimaryKey(VmUsers record);
}