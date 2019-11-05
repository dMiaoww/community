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
    private Date gmtCreate;
    private Date gmtModified;
    private String creator;
    private Integer likeCount;
    private Integer viewCount;
    private Integer commentCount;
    private User user;
}
