package com.xh.seata.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultJSON {
    private Integer code;
    private Object data;
    private boolean success;
    private String msg;

    public static ResultJSON success(Object data){
        return new ResultJSON(200,data,true,"success");
    }

    public static ResultJSON fail(Integer code,String msg){
        return new ResultJSON(code,null,false,msg);
    }
}
