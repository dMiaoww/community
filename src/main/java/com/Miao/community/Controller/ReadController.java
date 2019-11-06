package com.Miao.community.Controller;

import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/10/25 0025 16:19
 * @description：
 */
@Controller
public class ReadController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/read")
    public String read(@RequestParam(name = "qid") Integer qid,
                       Model model){
        //累加阅读数
        questionService.incView(qid);
        QuestionDTO questionDTO = questionService.findByID(qid);
        model.addAttribute("targetQuestion",questionDTO);
        return "read";
    }
}
