package com.Miao.community.Controller;

import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
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
    QuestionMapper questionMapper;
    @Autowired
    Usermapper usermapper;

    @GetMapping("/read")
    public String read(@RequestParam(name = "qid") Integer qid,
                       Model model){

        Question question = questionMapper.findByID(qid);
        User user = usermapper.findByAccountId(question.getCreator());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);  //将 question 对象的属性复制到 questionDTO 对象上
        questionDTO.setUser(user);
        model.addAttribute("targetQuestion",questionDTO);
        return "read";
    }
}
