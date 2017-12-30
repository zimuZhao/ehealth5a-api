package api.controller;

import api.annotations.Intent;
import api.model.User;
import api.service.UserService;
import api.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
        SessionUtil.setUser(request, user);
        return user;
    }

    /**
     * 测试接口：nginx跨域携带cookie
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("test")
    public void Test(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.getName();
                cookie.getValue();
                response.getWriter().print(cookie.getName() + ": " + cookie.getValue());
            }
        } else {
            Cookie cookie = new Cookie("ZIMU", "testNginx");
            response.addCookie(cookie);
            response.getWriter().print("First request: Cookie writing successful~");
        }
    }

}
