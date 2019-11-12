package com.Miao.community.mapper;

import com.Miao.community.model.Question;

public interface QuestionExtMapper {

    int incView(Question record);

    int incComment(Question record);
}