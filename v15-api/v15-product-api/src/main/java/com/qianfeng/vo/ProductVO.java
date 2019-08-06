package com.qianfeng.vo;

import com.qianfeng.entity.TProduct;
import com.qianfeng.entity.TProductDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO  implements Serializable {
    private TProduct product;
    private TProductDescription description;
}
