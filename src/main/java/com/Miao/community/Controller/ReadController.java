package com.Miao.community.Controller;

import com.Miao.community.DTO.CommentDTO;
import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.model.Comment;
import com.Miao.community.service.CommentSevice;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/10/25 0025 16:19
 * @description：
 */
@Controller
public class ReadController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentSevice commentSevice;

    @GetMapping("/read")
    public String read(@RequestParam(name = "qid") Integer qid,
                       Model model){
        QuestionDTO questionDTO = questionService.findByID(qid);
        model.addAttribute("targetQuestion",questionDTO);

        List<CommentDTO> commentDTOS = commentSevice.listByQuestionID(qid);
        model.addAttribute("comments",commentDTOS);

        //累加阅读数
        questionService.incView(qid);
        return "read";
    }
}
