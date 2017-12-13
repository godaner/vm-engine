package com.vm.dao.mapper;

import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmFilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmFilesMapper {
    long countByExample(VmFilesExample example);

    int deleteByExample(VmFilesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmFiles record);

    int insertSelective(VmFiles record);

    List<VmFiles> selectByExample(VmFilesExample example);

    VmFiles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmFiles record, @Param("example") VmFilesExample example);

    int updateByExample(@Param("record") VmFiles record, @Param("example") VmFilesExample example);

    int updateByPrimaryKeySelective(VmFiles record);

    int updateByPrimaryKey(VmFiles record);
}