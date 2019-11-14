package com.Miao.community.mapper;

import com.Miao.community.model.Comment;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/13 0013 15:48
 * @description：
 */
public interface CommentExtMapper {
    int incLikeCount(Comment record);
}
