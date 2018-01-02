package com.vm.dao.mapper;

import com.vm.dao.po.VmAdmins;
import com.vm.dao.po.VmAdminsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmAdminsMapper {
    long countByExample(VmAdminsExample example);

    int deleteByExample(VmAdminsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmAdmins record);

    int insertSelective(VmAdmins record);

    List<VmAdmins> selectByExample(VmAdminsExample example);

    VmAdmins selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmAdmins record, @Param("example") VmAdminsExample example);

    int updateByExample(@Param("record") VmAdmins record, @Param("example") VmAdminsExample example);

    int updateByPrimaryKeySelective(VmAdmins record);

    int updateByPrimaryKey(VmAdmins record);
}