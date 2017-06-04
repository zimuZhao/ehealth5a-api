package api.controller;

import api.annotations.Intent;
import api.model.User;
import api.service.UserService;
import api.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService service;

    @ResponseBody
    @Intent("登录")
    @RequestMapping("in")
    public Object in(String username, String password, HttpServletRequest request) throws Exception {
        //UserService.login()方法中已对user进行判断，如不能正确的返回user则抛出异常
        User user = service.login(username, password);
//        user.setPassword(null);
        SessionUtil.setUser(request , user);
        return user;
    }

}
