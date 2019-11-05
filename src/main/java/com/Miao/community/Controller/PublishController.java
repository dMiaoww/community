package com.Miao.community.Controller;

import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    private Question question = new Question();

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{qid}")
    public String edit(@PathVariable(name="qid") Integer qid,
                       Model model) {
        QuestionDTO question = questionService.findByID(qid);
        model.addAttribute("title", question.getTitle());
        model.addAttribute("description", question.getDescription());
        model.addAttribute("tag", question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id",required = false) Integer id,
            HttpServletRequest request,
            Model model) {
        //model用来往前端页面传递信息,回显到页面
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "问题标题不能为空！");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "问题描述不能为空！");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "问题标签不能为空！");
            return "publish";
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "请先登录！");
            return "publish";
        }
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getAccountid());
        question.setId(id);
        questionService.createOrUpdate(question);
        //发布成功，返回主页面
        return "redirect:/";
    }
}
