package com.blizi.blog.service;

import com.blizi.blog.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface UserService {
    List<User> selectAll();
    User selectUserByUserName(String username);
    void addUser(User user);
}
