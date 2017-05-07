package com.rui.dao.base;

import com.rui.entity.base.Safe;
import com.rui.entity.base.SafeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SafeMapper {
    int countByExample(SafeExample example);

    int deleteByExample(SafeExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Safe record);

    int insertSelective(Safe record);

    List<Safe> selectByExample(SafeExample example);

    Safe selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Safe record, @Param("example") SafeExample example);

    int updateByExample(@Param("record") Safe record, @Param("example") SafeExample example);

    int updateByPrimaryKeySelective(Safe record);

    int updateByPrimaryKey(Safe record);
}