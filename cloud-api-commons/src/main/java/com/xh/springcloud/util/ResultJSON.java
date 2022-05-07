package com.xh.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJSON<T> {

    private Integer code;
    private String msg;
    private T data;

    public ResultJSON<T> success(T data){
        return new ResultJSON<>(200,"success",data);
    }

    public ResultJSON<T> fail(Integer code,String msg){
        return new ResultJSON<T>(code,msg,null);
    }
}
