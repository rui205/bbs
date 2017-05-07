package com.rui.service.login;

import com.rui.entity.login.TieCustom;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface TieService {
    public List<TieCustom> findByCondition(Integer offset,Integer rows,String condition) throws Exception;
    public int countTie(String condition)throws Exception;
}
