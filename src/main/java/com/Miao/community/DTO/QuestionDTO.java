package com.Miao.community.DTO;

import com.Miao.community.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Date gmt_Create;
    private Date gmt_Modified;
    private Integer creator;
    private Integer like_count;
    private Integer view_count;
    private Integer comment_count;
    private User user;
}
