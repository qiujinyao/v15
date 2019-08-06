package com.qianfeng.mapper;

import com.qianfeng.base.BaseDao;
import com.qianfeng.entity.TProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TProductMapper extends BaseDao<TProduct> {

    List<TProduct> listProduct();

    List<TProduct> listPageination();

    int deleteChecked(@Param("deleteIds") List<Long> deleteIds);
}