package com.csdj.bookmanage.service;

import com.csdj.bookmanage.entity.Book;
import com.csdj.bookmanage.entity.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);
    public User findUser(String userName);
    /**
     * 查询书籍信息
     * @return
     */
    public List<Book> listbook();
}
