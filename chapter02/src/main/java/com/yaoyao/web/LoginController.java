package com.yaoyao.web;

import com.yaoyao.domain.User;
import com.yaoyao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by yaoyao on 2017-08-18.
 */
//标注成为一个Spring MVC的Controller
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //负责处理/index.html请求
    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }

    //负责处理/loginCheck.html的请求
    @RequestMapping(value = "loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if(!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误。");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastip(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }

}
