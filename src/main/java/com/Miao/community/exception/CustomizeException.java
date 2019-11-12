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
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

}
