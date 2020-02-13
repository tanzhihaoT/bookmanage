package com.csdj.bookmanage.service.impl;

import com.csdj.bookmanage.entity.Book;
import com.csdj.bookmanage.entity.User;
import com.csdj.bookmanage.mapper.UserMapper;
import com.csdj.bookmanage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User findUser(String userName) {
        return userMapper.findUser(userName);
    }

    @Override
    public List<Book> listbook() {
        return userMapper.listbook();
    }
}
