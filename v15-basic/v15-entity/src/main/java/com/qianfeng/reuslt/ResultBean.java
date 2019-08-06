package com.qianfeng.reuslt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiujinyao
 * @version 1.0
 * @Date 2019/8/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean<T> {
    private String statusCode;
    private T data;
}
