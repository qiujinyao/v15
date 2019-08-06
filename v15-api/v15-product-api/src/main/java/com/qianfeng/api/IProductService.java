package com.qianfeng.api;

import com.github.pagehelper.PageInfo;
import com.qianfeng.base.BaseService;
import com.qianfeng.entity.TProduct;
import com.qianfeng.vo.ProductVO;

import java.util.List;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/5
 */
public interface IProductService extends BaseService<TProduct> {
    List<TProduct> listProduct();

    PageInfo<TProduct> listPageination(Integer pageIndex, Integer pageSize);

    int insertProduct(ProductVO productVO);

    int deleteChecked(List<Long> deleteIds);

    int updateProduct(ProductVO productVO);
}
