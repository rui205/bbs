package com.rui.dao.login;

import com.rui.entity.login.TieCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface TieDao {
    /**
     * 查找置顶帖
     * @param offset
     * @param rows
     * @return
     * @throws Exception
     */
    public List<TieCustom> findByCondition(@Param("offset")Integer offset, @Param("rows")Integer rows,
                                           @Param("condition")String condition) throws Exception;

    /**
     * 计算的贴的数量
     * @return
     */
    public int countTie(@Param("condition")String condition);
}
