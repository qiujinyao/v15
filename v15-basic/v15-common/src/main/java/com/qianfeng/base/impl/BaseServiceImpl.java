package com.qianfeng.base.impl;

import com.qianfeng.base.BaseDao;
import com.qianfeng.base.BaseService;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/5
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
   public  abstract BaseDao<T> getBaseDao();

    public int deleteByPrimaryKey(Long Id) {
        return getBaseDao().deleteByPrimaryKey(Id);
    }

    public int insert(T record) {
        return getBaseDao().insert(record);
    }

    public int insertSelective(T record) {
        return getBaseDao().insertSelective(record);
    }

    public T selectByPrimaryKey(Long Id) {
        return getBaseDao().selectByPrimaryKey(Id);
    }

    public int updateByPrimaryKeySelective(T record) {
        return getBaseDao().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyWithBLOBs(T record) {
        return getBaseDao().updateByPrimaryKeyWithBLOBs(record);
    }

    public int updateByPrimaryKey(T record) {
        return getBaseDao().updateByPrimaryKey(record);
    }
}
