package com.Miao.community.service;

import com.Miao.community.DTO.PaginationDTO;
import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private Usermapper usermapper;

    //用于首页显示所有问题
    public PaginationDTO list(Integer page, Integer size) {
        //当前数据库中的问题总数
        Integer totalCount = questionMapper.questionCount();
        //select语句的偏移量
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.allList(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            User user = usermapper.findByAccountId(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }

    //用于个人中心显示我的提问
    public PaginationDTO list(Integer page, Integer size, String accountID){
        //当前数据库中的我的提问总数
        Integer totalCount = questionMapper.userQuestionCount(accountID);
        //select语句的偏移量
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.userList(offset,size,accountID);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questionList) {
            User user = usermapper.findByAccountId(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }

    public QuestionDTO findByID(Integer qid) {
        Question question = questionMapper.findByID(qid);
        User user = usermapper.findByAccountId(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
        questionDTO.setUser(user);
        return questionDTO;
    }
}
