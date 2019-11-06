package com.Miao.community.exception;

import lombok.Data;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/5 0005 17:08
 * @description：
 */
@Data
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(String message){
        this.message = message;
    }
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
    }

}
