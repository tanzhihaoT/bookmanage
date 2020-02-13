package com.csdj.bookmanage.mapper;

import com.csdj.bookmanage.entity.Book;
import com.csdj.bookmanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User findUser(String userName);

    /**
     * 查询书籍信息
     * @return
     */
    public List<Book> listbook();
}
