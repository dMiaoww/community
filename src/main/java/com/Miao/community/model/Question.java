package com.Miao.community.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Date gmt_Create;
    private Date gmt_Modified;
    private String   creator;
    private Integer like_count;
    private Integer view_count;
    private Integer comment_count;

    //integer 可以区分出未赋值和值为0的区别
}
