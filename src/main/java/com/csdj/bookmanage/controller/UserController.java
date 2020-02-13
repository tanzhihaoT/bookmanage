package com.csdj.bookmanage.controller;

import com.alibaba.fastjson.JSON;
import com.csdj.bookmanage.entity.Book;
import com.csdj.bookmanage.entity.User;
import com.csdj.bookmanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.CodecException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.UnknownAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("main.html")
    public String main(){
        return "main";
    }
    @RequestMapping("book_show.html")
    public String book_show(){
        return "book_show";
    }

    @RequestMapping("login")
    @ResponseBody
    public String toLogin(User user, Model model){

        //System.out.println(newUser.getName()+newUser.getPassword());
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),user.getPassword());
        //执行登录方法,用捕捉异常去判断是否登录成功
        try {
            subject.login(userToken);
            Session session = subject.getSession();
            session.setAttribute("subject", subject);
            return "1";
        } catch (AuthenticationException e) {
            return "0";
        }

    }

    @RequestMapping("addUser")
    @ResponseBody
    public int addUser(User user){
        int i= 0;
        try {
            String salt=new SecureRandomNumberGenerator().nextBytes().toString();
            user.setSalt(salt);
            String encodedPassword= new SimpleHash("md5",user.getPassword(),salt,2).toString();
            user.setPassword(encodedPassword);
            i = userService.addUser(user);
        } catch (CodecException e) {
            return 0;
        } catch (UnknownAlgorithmException e) {
            return 0;
        }
        return i;
    }

    /**
     * 查询书籍信息
     * @return
     */
    @RequestMapping("find_book.htmls")
    @ResponseBody
    public Object findBook(){
        List<Book> bookList=userService.listbook();
        String jsonString= JSON.toJSONString(bookList);
        System.out.println(jsonString);
        int count=1;
        String layuiJson = "{\"code\":0,\"msg\":\"\",\"count\":" + count + ",\"data\":" + jsonString + "}";// 转换成layui数据表格的值格式
        return layuiJson;
    }
}
