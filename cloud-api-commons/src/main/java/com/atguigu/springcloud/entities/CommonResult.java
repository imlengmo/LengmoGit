package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zam
 * @date 2022/1/2 -16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String  message;
    private T data;

    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }
}

