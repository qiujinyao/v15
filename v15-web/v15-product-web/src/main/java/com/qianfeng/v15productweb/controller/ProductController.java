package com.qianfeng.v15productweb.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.qianfeng.api.IProductService;
import com.qianfeng.entity.TProduct;
import com.qianfeng.reuslt.ResultBean;
import com.qianfeng.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/5
 */
@Controller
@RequestMapping("product")
public class ProductController {
    @Reference
    private IProductService productService;

    @RequestMapping("list")
    public String listProduct(Model model){
        List<TProduct> productList = productService.listProduct();
        model.addAttribute("productList",productList);
        return "productpage/product_list";
    }

    //分页查询
    @RequestMapping("pagination/{pageIndex}/{pageSize}")
    public  String listPageination(@PathVariable Integer pageIndex,@PathVariable Integer pageSize,Model model){
        PageInfo<TProduct> pageInfo= productService.listPageination(pageIndex,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "productpage/product_list";
    }
   //添加商品
    @RequestMapping("insertproduct")
    @ResponseBody
    public ResultBean<String> insertProduct(ProductVO productVO){
         int result=productService.insertProduct(productVO);
         if (result!=0){
             return  new ResultBean<String>("200", "添加成功");
         }
           return new ResultBean<String>("404", "服务器未响应，请稍后重试");
    }

    //删除单个商品
    @RequestMapping("deleteProductbyProductId")
    @ResponseBody
    public  ResultBean<String> deleteProductbyProductId(@RequestParam Long id){
          int reult=productService.deleteByPrimaryKey(id);
          if(reult>0){
              return  new ResultBean<String>("200", "删除成功！");
          }
          return new ResultBean<String>("404", "服务器未响应，请稍后重试！");
        }
      //删除全部商品
    @RequestMapping("deletechecked")
    @ResponseBody
    public  ResultBean<String> deleteChecked(@RequestParam("deleteIds") List<Long> deleteIds){
        int result=productService.deleteChecked(deleteIds);
        if(result>0){
            return  new ResultBean<>("200", "删除成功！");
        }
        return new ResultBean<>("404", "服务器未响应，请稍后重试！");
    }
    @RequestMapping("page")
    public String topage(){
        return "commonpage/conslepage";
    }

    @RequestMapping("selectproduct/{id}")
    @ResponseBody
    public TProduct selectProduct(@PathVariable Long id){
         TProduct product = productService.selectByPrimaryKey(id);
         return product;
    }
    @RequestMapping("updataproduct")
    @ResponseBody
    public ResultBean<String> updateProduct(ProductVO productVO){
          int result=productService.updateProduct(productVO);
          if (result>0){
              return  new ResultBean<>("200", "修改成功");
          }
          return new ResultBean<>("404", "服务器未响应，请稍后重试！");
    }
}
