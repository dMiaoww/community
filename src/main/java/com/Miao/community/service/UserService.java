package com.Miao.community.service;

import com.Miao.community.mapper.UserMapper;
import com.Miao.community.model.User;
import com.Miao.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/4 0004 14:31
 * @description：
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountidEqualTo(user.getAccountid());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            // 插入
            user.setGmtcreate(new Date(System.currentTimeMillis()));
            user.setGmtmodified(user.getGmtcreate());
            user.setBio("这个人很懒，什么都没有写");
            userMapper.insert(user);
        } else {
            // 更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtmodified(new Date(System.currentTimeMillis()));
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        }
    }
}
