package com.blizi.blog.service.impl;

import com.blizi.blog.entity.User;
import com.blizi.blog.mapper.UserMapper;
import com.blizi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public User selectUserByUserName(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name",username);
        List<User> users = mapper.selectByExample(example);
        if(users.size()!=0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        mapper.insert(user);
    }
}
