package com.Miao.community.model;

import java.util.Date;

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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getGmt_Create() {
        return gmt_Create;
    }

    public void setGmt_Create(Date gmt_Create) {
        this.gmt_Create = gmt_Create;
    }

    public Date getGmt_Modified() {
        return gmt_Modified;
    }

    public void setGmt_Modified(Date gmt_Modified) {
        this.gmt_Modified = gmt_Modified;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }
}
