package com.Miao.community.mapper;

import com.Miao.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Usermapper {
    @Insert("insert into user (name,accountID,token,gmtCreate,gmtModified) values (#{name},#{accountID},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
