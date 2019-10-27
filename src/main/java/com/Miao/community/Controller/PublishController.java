package com.Miao.community.Controller;

import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PublishController {
    private Question question = new Question();

    @Autowired
    QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model){
        //model用来往前端页面传递信息
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title == null || title == ""){
            model.addAttribute("error","问题标题不能为空！");
            return "publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error","问题描述不能为空！");
            return "publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error","问题标签不能为空！");
            return "publish";
        }
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","请先登录！");
            return "publish";
        }
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getAccountID());
        question.setComment_count(0);
        question.setLike_count(0);
        question.setView_count(0);
        question.setGmt_Create(new Date(System.currentTimeMillis()));
        question.setGmt_Modified(question.getGmt_Create());
        questionMapper.create(question);
        //发布成功，返回主页面
        return "redirect:/";
    }

}
