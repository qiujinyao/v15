package com.qianfeng.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TProductDescription implements Serializable {
    private Long tProductDescriptionId;

    private Long tProductId;

    private Boolean flag;

    private String tProductDescriptioncontext;

}