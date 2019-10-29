package com.Miao.community.Controller;

import com.Miao.community.DTO.PaginationDTO;
import com.Miao.community.DTO.QuestionDTO;
import com.Miao.community.mapper.QuestionMapper;
import com.Miao.community.mapper.Usermapper;
import com.Miao.community.model.Question;
import com.Miao.community.model.User;
import com.Miao.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "sort", defaultValue = "new") String sort,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "6") Integer size) {

        if ("zero".equals(sort)) {
            PaginationDTO zeroPagination = questionService.zeroList(page, size);
            model.addAttribute("pagination", zeroPagination);
        }
        else if ("hot".equals(sort)) {
            PaginationDTO hotPagination = questionService.hotList(page, size);
            model.addAttribute("pagination", hotPagination);
        }
        else {
            PaginationDTO newPagination = questionService.newList(page, size);
            model.addAttribute("pagination", newPagination);
        }
        model.addAttribute("sort", sort);
        return "index";
    }

}
