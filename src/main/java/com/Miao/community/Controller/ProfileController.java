package com.Miao.community.Controller;

import com.Miao.community.DTO.PaginationDTO;
import com.Miao.community.model.User;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/10/23 0023 10:16
 * @description：
 */
@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "6") Integer size,
                          Model model) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO pagination = questionService.list(page, size, user.getAccountid());
            model.addAttribute("pagination", pagination);
        } else if ("comments".equals(action)) {
            model.addAttribute("section", "comments");
            model.addAttribute("sectionName", "最新回复");
        }else if ("myComment".equals(action)) {
            model.addAttribute("section", "myComment");
            model.addAttribute("sectionName", "我的回复");
        }else if ("collection".equals(action)) {
            model.addAttribute("section", "collection");
            model.addAttribute("sectionName", "我的收藏");
        }else if ("information".equals(action)) {
            model.addAttribute("section", "information");
            model.addAttribute("sectionName", "我的资料");
        }

        return "profile";
    }
}
