package com.Miao.community.Controller;

import com.Miao.community.DTO.AccesstokenDTO;
import com.Miao.community.DTO.GithubUser;
import com.Miao.community.mapper.UserMapper;
import com.Miao.community.model.User;
import com.Miao.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private String clientID;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String uri;

    //登陆
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response) {
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setClient_id(clientID);
        accesstokenDTO.setClient_secret(clientSecret);
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(uri);
        accesstokenDTO.setState(state);
        String accesstoken = githubProvider.getAccessToken(accesstokenDTO);
        GithubUser githubUser = githubProvider.getUser(accesstoken);
        if(githubUser != null && githubUser.getId() != null){
            //登陆成功
            //将用户信息写入数据库
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getLogin());
            user.setAccountid(String.valueOf(githubUser.getId()));
            user.setGmtcreate(new Date(System.currentTimeMillis()));
            user.setGmtmodified(user.getGmtcreate());
            user.setAvatarUrl(githubUser.getAvatar_url());
            userMapper.insert(user);
            //写cookie和session
            response.addCookie(new Cookie("token",token));
            return "redirect:/";//TODO:可以回到当前页面么？
        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }

    //退出登陆
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
