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

    @Select("select * from question order by gmt_Modified DESC limit #{size} offset #{offset}")
    List<Question> allList(Integer offset, Integer size);

    @Select("SELECT COUNT(id) FROM question")
    Integer questionCount();

    @Select("select * from question where creator = #{accountID} order by gmt_Modified DESC limit #{size} offset #{offset}")
    List<Question> userList(Integer offset, Integer size, String accountID);

    @Select("SELECT COUNT(id) FROM question where creator = #{accountID}")
    Integer userQuestionCount(String accountID);

    @Select("SELECT * FROM question where id = #{id}")
    Question findByID(Integer id);
}
