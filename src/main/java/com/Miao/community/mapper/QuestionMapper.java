package com.Miao.community.mapper;

import com.Miao.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_Create,gmt_Modified,creator,view_count,like_count,comment_count,tag) values (#{title},#{description},#{gmt_Create},#{gmt_Modified},#{creator},#{view_count},#{like_count},#{comment_count},#{tag})")
    void create(Question question);

    @Select("select * from question order by gmt_Modified DESC limit #{size} offset #{offset}")
    List<Question> newList(Integer offset, Integer size);

    @Select("SELECT * FROM question ORDER BY comment_count DESC limit #{size} offset #{offset}")
    List<Question> hotList(Integer offset, Integer size);

    @Select("SELECT * FROM question WHERE comment_count = 0 ORDER BY gmt_Modified DESC limit #{size} offset #{offset}")
    List<Question> zeroList(Integer offset, Integer size);

    @Select("SELECT COUNT(id) FROM question")
    Integer questionCount();

    @Select("select * from question where creator = #{accountID} order by gmt_Modified DESC limit #{size} offset #{offset}")
    List<Question> userList(Integer offset, Integer size, String accountID);

    @Select("SELECT COUNT(id) FROM question where creator = #{accountID}")
    Integer userQuestionCount(String accountID);

    @Select("SELECT * FROM question where id = #{id}")
    Question findByID(Integer id);

    @Select("SELECT COUNT(id) FROM question where comment_count = 0")
    Integer questionCountWithNoComment();

    @Update("update question set title = #{title}, description = #{description},gmt_Modified = #{gmt_Modified},tag  = #{tag} where id = #{id}")
    void update(Question question);
}
