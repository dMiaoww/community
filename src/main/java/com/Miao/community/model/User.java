package com.Miao.community.model;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.accountID
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String accountid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.token
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmtCreate
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private Date gmtcreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.gmtModified
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private Date gmtmodified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bio
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar_url
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String avatarUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.accountID
     *
     * @return the value of user.accountID
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getAccountid() {
        return accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.accountID
     *
     * @param accountid the value for user.accountID
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.token
     *
     * @return the value of user.token
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.token
     *
     * @param token the value for user.token
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmtCreate
     *
     * @return the value of user.gmtCreate
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmtCreate
     *
     * @param gmtcreate the value for user.gmtCreate
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.gmtModified
     *
     * @return the value of user.gmtModified
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public Date getGmtmodified() {
        return gmtmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.gmtModified
     *
     * @param gmtmodified the value for user.gmtModified
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setGmtmodified(Date gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bio
     *
     * @return the value of user.bio
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bio
     *
     * @param bio the value for user.bio
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar_url
     *
     * @return the value of user.avatar_url
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar_url
     *
     * @param avatarUrl the value for user.avatar_url
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}