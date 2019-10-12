package com.Miao.community.Controller;

import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    private String token;

    @Autowired
    private Usermapper usermapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")){
                    token = cookie.getValue();
                    break;
                }
            }
            User user = usermapper.finByToken(token);
            if(user != null){
                request.getSession().setAttribute("user",user);
            }
        }
        return "index";
    }

}
