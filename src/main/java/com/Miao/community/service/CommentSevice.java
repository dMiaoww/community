package com.Miao.community.service;

import com.Miao.community.DTO.CommentDTO;
import com.Miao.community.enums.CommentTypeEnum;
import com.Miao.community.exception.CustomizeErrorCode;
import com.Miao.community.exception.CustomizeException;
import com.Miao.community.mapper.CommentExtMapper;
import com.Miao.community.mapper.CommentMapper;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.UserMapper;
import com.Miao.community.model.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/7 0007 14:19
 * @description：
 */
@Service
public class CommentSevice {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    //添加评论, @Transactional 注解将整个方法体封装成一个事务
    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question dbQuestion = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (dbQuestion == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            questionService.incComment(comment.getParentId());
        }
    }

    // read 页面的回复
    public List<CommentDTO> listByQuestionID(Integer qid) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(qid)
                .andTypeEqualTo(CommentTypeEnum.QUESTION.getType());
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);

        //将所有评论人的 AcccountID 放到一个 set 中，达到去重效果
        if (comments.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> commentors = comments.stream().map(comment -> comment.getCommentor()).collect(Collectors.toSet());
        List<String> userAIDs = new ArrayList<>();
        userAIDs.addAll(commentors);

        //根据上一步的 set 获取评论人对象，构造一个 K：AccountID，V：user 的map
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountidIn(userAIDs);
        List<User> users = userMapper.selectByExample(userExample);
        Map<String, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getAccountid(), user -> user));

        //转换 comment 为 commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentor()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;

    }

    //点赞回复
    public void incLikeCount(Integer cid){
        Comment comment = new Comment();
        comment.setId(cid);
        comment.setLikeCount(1);
        commentExtMapper.incLikeCount(comment);
    }
}
