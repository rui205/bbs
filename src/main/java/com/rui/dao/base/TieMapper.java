package com.rui.dao.base;

import com.rui.entity.base.Tie;
import com.rui.entity.base.TieExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TieMapper {
    int countByExample(TieExample example);

    int deleteByExample(TieExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Tie record);

    int insertSelective(Tie record);

    List<Tie> selectByExample(TieExample example);

    Tie selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Tie record, @Param("example") TieExample example);

    int updateByExample(@Param("record") Tie record, @Param("example") TieExample example);

    int updateByPrimaryKeySelective(Tie record);

    int updateByPrimaryKey(Tie record);
}