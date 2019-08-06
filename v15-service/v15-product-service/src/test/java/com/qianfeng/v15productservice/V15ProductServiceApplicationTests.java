package com.qianfeng.v15productservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.qianfeng.api.IProductService;
import com.qianfeng.entity.TProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith ( SpringRunner.class )
@SpringBootTest
@EnableDubbo
@MapperScan("com.qianfeng.mapper")
public class V15ProductServiceApplicationTests {
    @Autowired
    private IProductService productService;
    @Autowired
    private DataSource dataSource;
    @Test
    public void contextLoads() {
        TProduct tProduct = productService.selectByPrimaryKey(1L);
        System.out.println(tProduct);
    }

    @Test
    public void testListProduct(){
        List<TProduct> productList = productService.listProduct();
        for (TProduct product : productList) {
            System.out.println(product);
        }
    }
    @Test
    public  void testConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

}
