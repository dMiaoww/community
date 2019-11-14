package com.Miao.community.Controller;

import com.Miao.community.DTO.CommentCreateDTO;
import com.Miao.community.DTO.ResultDTO;
import com.Miao.community.exception.CustomizeErrorCode;
import com.Miao.community.model.Comment;
import com.Miao.community.model.User;
import com.Miao.community.service.CommentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/7 0007 10:02
 * @description：
 */
@Controller
public class CommentController {

    @Autowired
    private CommentSevice commentSevice;

    //@ResponseBody：将对象封装成json发送给前端
    //@RequestBody: 将json解析成对象
    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request,
                       Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
           return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setCommentor(user.getAccountid());
        comment.setGmtCreate(new Date(System.currentTimeMillis()));
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0);
        commentSevice.insert(comment);
        return ResultDTO.successOf();
    }
}
