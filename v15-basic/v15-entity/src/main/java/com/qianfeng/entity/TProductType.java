package com.qianfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TProductType implements Serializable {
    private Long productTypeId;

    private Long productTypePid;

    private Boolean flag;

    private String productTypeName;

}