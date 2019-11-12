package com.Miao.community.service;

import com.Miao.community.DTO.PaginationDTO;
import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.exception.CustomizeErrorCode;
import com.Miao.community.exception.CustomizeException;
import com.Miao.community.mapper.QuestionExtMapper;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.UserMapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.QuestionExample;
import com.Miao.community.model.User;
import com.Miao.community.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    //用于首页显示最新问题
    public PaginationDTO newList(Integer page, Integer size) {
        //当前数据库中的问题总数
        QuestionExample questionExampleForTotalCount = new QuestionExample();
        questionExampleForTotalCount.createCriteria()
                .andIdIsNotNull();
        Integer totalCount = (int)questionMapper.countByExample(questionExampleForTotalCount);
        //select语句的偏移量
        Integer offset = size * (page - 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.setOrderByClause("gmt_create DESC");         //应该写database中的字段名
        RowBounds rowBounds = new RowBounds(offset, size);
        List<Question> questionList = questionMapper.selectByExampleWithBLOBsWithRowbounds(questionExample,rowBounds);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountidEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount, page, size);
        return paginationDTO;
    }

    //用于个人中心显示我的提问
    public PaginationDTO list(Integer page, Integer size, String accountID) {
        //当前数据库中的我的提问总数
        QuestionExample questionExampleForMyQuestion = new QuestionExample();
        questionExampleForMyQuestion.createCriteria()
                .andCreatorEqualTo(accountID);
        Integer totalCount = (int)questionMapper.countByExample(questionExampleForMyQuestion);
        //select语句的偏移量
        Integer offset = size * (page - 1);
        questionExampleForMyQuestion.setOrderByClause("gmt_create DESC");
        RowBounds rowBounds = new RowBounds(offset, size);
        List<Question> questionList = questionMapper.selectByExampleWithBLOBsWithRowbounds(questionExampleForMyQuestion,rowBounds);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountidEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount, page, size);
        return paginationDTO;
    }

    //根据question的id查找question和对应的user
    public QuestionDTO findByID(Integer qid) {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andIdEqualTo(qid);
        List<Question> questions = questionMapper.selectByExampleWithBLOBs(questionExample);
        if(questions.size() == 0){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountidEqualTo(questions.get(0).getCreator());
        List<User> users = userMapper.selectByExample(userExample);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(questions.get(0), questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
        questionDTO.setUser(users.get(0));
        return questionDTO;
    }

    //用于首页显示最热问题
    public PaginationDTO hotList(Integer page, Integer size) {
        //当前数据库中的问题总数
        QuestionExample questionExampleForTotalCount = new QuestionExample();
        questionExampleForTotalCount.createCriteria()
                .andIdIsNotNull();
        Integer totalCount = (int)questionMapper.countByExample(questionExampleForTotalCount);
        //select语句的偏移量
        Integer offset = size * (page - 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.setOrderByClause("comment_count DESC");
        RowBounds rowBounds = new RowBounds(offset, size);
        List<Question> questionList = questionMapper.selectByExampleWithBLOBsWithRowbounds(questionExample,rowBounds);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountidEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount, page, size);
        return paginationDTO;
    }

    //用于首页显示零回复的问题
    public PaginationDTO zeroList(Integer page, Integer size) {
        //当前数据库中的无评论问题总数
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCommentCountEqualTo(0);
        Integer totalCount = (int)questionMapper.countByExample(questionExample);
        //select语句的偏移量
        Integer offset = size * (page - 1);
        questionExample.setOrderByClause("gmt_create DESC");
        RowBounds rowBounds = new RowBounds(offset, size);
        List<Question> questionList = questionMapper.selectByExampleWithBLOBsWithRowbounds(questionExample,rowBounds);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountidEqualTo(question.getCreator());
            List<User> users = userMapper.selectByExample(userExample);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(users.get(0));
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount, page, size);
        return paginationDTO;
    }

    //用于发布页面发布或更新问题
    public void createOrUpdate(Question question) {
        //发布
        if (question.getId() == null) {
            question.setGmtCreate(new Date(System.currentTimeMillis()));
            question.setGmtModified(question.getGmtCreate());
            question.setCommentCount(0);
            question.setLikeCount(0);
            question.setViewCount(0);
            questionMapper.insert(question);
        }
        //更新
        else {
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria()
                    .andIdEqualTo(question.getId());
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(new Date(System.currentTimeMillis()));
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            int updated = questionMapper.updateByExampleSelective(updateQuestion,questionExample);
            if(updated != 1){
                throw new CustomizeException(CustomizeErrorCode.UPDATE_FAILED);
            }
        }
    }

    //点击页面增加问题的阅读数
    public void incView(Integer qid) {
        Question question = new Question();
        question.setId(qid);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }

    //增加问题的回复数
    public void incComment(Integer qid){
        Question question = new Question();
        question.setId(qid);
        question.setCommentCount(1);
        questionExtMapper.incComment(question);
    }
}
