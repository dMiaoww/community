package com.Miao.community.exception;


/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/5 0005 17:29
 * @description：
 */

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("问题不存在或已删除"),
    UPDATE_FAILED("更新失败，请重试！");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message){
        this.message = message;
    }
}
