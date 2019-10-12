package com.Miao.community.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountID;
    private String token;
    private Date gmtCreate;
    private Date gmtModified;
    private String avatar_url;

}
