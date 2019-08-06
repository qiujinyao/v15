package com.qianfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TProduct implements Serializable {
    private Long tProductId;

    private String tProductName;

    private Long tProductSaleprice;

    private Long tProductPrice;

    private Date tProductCreatetime;

    private Date tProductUpdatetime;

    private Long tProductTypeId;

    private String tProductPic;

    private String tProductTypeName;

    private String tProductSalepoint;

    private Boolean flag;

}