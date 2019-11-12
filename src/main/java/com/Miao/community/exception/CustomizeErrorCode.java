package com.Miao.community.exception;


/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/5 0005 17:29
 * @description：
 */

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    NOT_LOGIN(2000,"您尚未登陆，请先登陆！"),
    QUESTION_NOT_FOUND(2001,"问题不存在或已删除"),
    UPDATE_FAILED(2002,"更新失败，请重试！"),
    TARGET_PARAM_NOT_FOUND(2003,"没有选中任何问题或评论就进行了回复！"),
    TYPE_PARAM_WRONG(2004,"评论类型错误或不存在！"),
    SYS_ERROR(2005,"服务器冒烟了，要不稍后再试试？"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在或已删除");

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
