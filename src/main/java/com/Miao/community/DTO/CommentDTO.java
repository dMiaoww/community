package com.Miao.community.DTO;

import lombok.Data;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/7 0007 10:23
 * @description： 用于解析提交评论时获得的json对象
 */
@Data
public class CommentDTO {
    private Integer parentId;
    private String content;
    private Integer type;
}
