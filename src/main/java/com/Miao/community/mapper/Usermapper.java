package com.Miao.community.mapper;

import com.Miao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {
    @Insert("insert into user (name,accountID,token,gmtCreate,gmtModified,avatar_url) values (#{name},#{accountID},#{token},#{gmtCreate},#{gmtModified},#{avatar_url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User finByToken(String token);

    @Select("select * from user where accountID = #{accountID} limit 1")
    User findByAccountId(String accountID);
}
