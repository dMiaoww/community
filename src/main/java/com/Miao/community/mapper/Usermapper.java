package com.Miao.community.mapper;

import com.Miao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {
    @Insert("insert into user (name,accountID,token,gmtCreate,gmtModified) values (#{name},#{accountID},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User finByToken(@Param("token") String token);
}