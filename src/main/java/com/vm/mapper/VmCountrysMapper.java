package com.vm.mapper;

import com.vm.base.po.VmCountrys;
import com.vm.base.po.VmCountrysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmCountrysMapper {
    long countByExample(VmCountrysExample example);

    int deleteByExample(VmCountrysExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(VmCountrys record);

    int insertSelective(VmCountrys record);

    List<VmCountrys> selectByExample(VmCountrysExample example);

    VmCountrys selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") VmCountrys record, @Param("example") VmCountrysExample example);

    int updateByExample(@Param("record") VmCountrys record, @Param("example") VmCountrysExample example);

    int updateByPrimaryKeySelective(VmCountrys record);

    int updateByPrimaryKey(VmCountrys record);
}