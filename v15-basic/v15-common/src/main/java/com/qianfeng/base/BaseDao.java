package com.qianfeng.base;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/5
 */
public interface BaseDao<T>  {
    int deleteByPrimaryKey(Long Id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long Id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
