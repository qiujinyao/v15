package com.qianfeng.v15productservice.productserivce;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianfeng.api.IProductService;
import com.qianfeng.base.BaseDao;
import com.qianfeng.base.impl.BaseServiceImpl;
import com.qianfeng.entity.TProduct;
import com.qianfeng.entity.TProductDescription;
import com.qianfeng.mapper.TProductDescriptionMapper;
import com.qianfeng.mapper.TProductMapper;
import com.qianfeng.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/5
 */
@Service
public class ProductService extends BaseServiceImpl<TProduct> implements IProductService {

   @Autowired
   private TProductMapper ProductMapper;
   @Autowired
   private TProductDescriptionMapper productDescriptionMapper;

    @Override
    public BaseDao<TProduct> getBaseDao() {
        return ProductMapper;
    }

    @Override
    public List<TProduct> listProduct() {
        return ProductMapper.listProduct();
    }

    @Override
    public PageInfo<TProduct> listPageination(Integer pageIndex, Integer pageSize) {
        if (pageIndex==null){
            pageIndex=1;
        }
        if(pageSize==null){
            pageSize=1;
        }
        PageHelper.startPage(pageIndex, pageSize);
        List<TProduct> productList=ProductMapper.listPageination();
        return new PageInfo<>(productList, 3);
    }

    @Override
    @Transactional
    public int insertProduct(ProductVO productVO) {
        TProduct product = productVO.getProduct();
        ProductMapper.insertSelective(product);
        TProductDescription productDescription=productVO.getDescription();
        productDescription.setTProductId(product.getTProductId());
        productDescriptionMapper.insertSelective(productDescription);
        return product.getTProductId().intValue();
    }

    @Override
    public int deleteChecked(List<Long> deleteIds) {
        return ProductMapper.deleteChecked(deleteIds);
    }

    @Override
    @Transactional
    public int updateProduct(ProductVO productVO) {
        int result=ProductMapper.updateByPrimaryKeySelective(productVO.getProduct());
        TProductDescription description = productVO.getDescription();
        description.setTProductId(productVO.getProduct().getTProductId());
        productDescriptionMapper.updateByPrimaryKeySelective(description);
        if(result>0){
            return 1;
        }
        return 0;
    }
}
