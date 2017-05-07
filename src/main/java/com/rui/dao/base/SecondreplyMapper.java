package com.rui.dao.base;

import com.rui.entity.base.Secondreply;
import com.rui.entity.base.SecondreplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondreplyMapper {
    int countByExample(SecondreplyExample example);

    int deleteByExample(SecondreplyExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Secondreply record);

    int insertSelective(Secondreply record);

    List<Secondreply> selectByExample(SecondreplyExample example);

    Secondreply selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Secondreply record, @Param("example") SecondreplyExample example);

    int updateByExample(@Param("record") Secondreply record, @Param("example") SecondreplyExample example);

    int updateByPrimaryKeySelective(Secondreply record);

    int updateByPrimaryKey(Secondreply record);
}