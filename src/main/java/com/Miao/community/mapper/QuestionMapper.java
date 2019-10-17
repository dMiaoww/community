package com.Miao.community.mapper;

import com.Miao.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_Create,gmt_Modified,creator,view_count,like_count,comment_count,tag) values (#{title},#{description},#{gmt_Create},#{gmt_Modified},#{creator},#{view_count},#{like_count},#{comment_count},#{tag})")
    void create(Question question);

    @Select("select * from question limit #{size} offset #{offset}")
    List<Question> list(Integer offset, Integer size);

    @Select("SELECT COUNT(id) FROM question")
    Integer count();

}
