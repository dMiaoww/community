package com.Miao.community.DTO;

import com.Miao.community.model.User;
import lombok.Data;

import java.util.Date;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/13 0013 13:50
 * @description：
 */
@Data
public class CommentDTO {
    private Integer id;
    private Integer parentId;
    private Integer type;
    private String commentor;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer likeCount;
    private String content;
    private User user;
}
