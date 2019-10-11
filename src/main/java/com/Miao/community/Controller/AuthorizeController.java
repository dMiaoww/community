package com.Miao.community.Controller;

import com.Miao.community.DTO.AccesstokenDTO;
import com.Miao.community.DTO.GithubUser;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.User;
import com.Miao.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private Usermapper usermapper;

    @Value("${github.client.id}")
    private String clientID;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String uri;

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
            user.setAccountID(String.valueOf(githubUser.getId()));
            user.setGmtCreate(new Date(System.currentTimeMillis()));
            user.setGmtModified(user.getGmtCreate());
            usermapper.insert(user);
            //写cookie和session
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else{
            //登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
