package com.Miao.community.Controller;

import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/10/25 0025 16:19
 * @description：
 */
@Controller
public class ReadController {
    @Autowired
    QuestionService questionService;
    @Autowired
    Usermapper usermapper;

    @GetMapping("/read")
    public String read(@RequestParam(name = "qid") Integer qid,
                       Model model){
        QuestionDTO questionDTO = questionService.findByID(qid);
        model.addAttribute("targetQuestion",questionDTO);
        return "read";
    }
}
