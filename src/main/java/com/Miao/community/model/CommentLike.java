package com.Miao.community.model;

public class CommentLike {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commentlike.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commentlike.collector
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private String collector;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commentlike.comment_id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    private Integer commentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commentlike.id
     *
     * @return the value of commentlike.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commentlike.id
     *
     * @param id the value for commentlike.id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commentlike.collector
     *
     * @return the value of commentlike.collector
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public String getCollector() {
        return collector;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commentlike.collector
     *
     * @param collector the value for commentlike.collector
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setCollector(String collector) {
        this.collector = collector == null ? null : collector.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commentlike.comment_id
     *
     * @return the value of commentlike.comment_id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commentlike.comment_id
     *
     * @param commentId the value for commentlike.comment_id
     *
     * @mbg.generated Wed Nov 13 17:31:50 CST 2019
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}