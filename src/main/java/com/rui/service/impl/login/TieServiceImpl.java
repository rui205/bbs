package com.rui.service.impl.login;

import com.rui.dao.login.TieDao;
import com.rui.entity.login.TieCustom;
import com.rui.service.login.TieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
@Service
public class TieServiceImpl implements TieService {
    @Resource
    private TieDao tieDao;
    public List<TieCustom> findByCondition(Integer offset,Integer rows,String condition) throws Exception {
        return this.tieDao.findByCondition(offset,rows,condition);
    }

    public int countTie(String condition)throws Exception{
        return this.tieDao.countTie(condition);
    }
}
