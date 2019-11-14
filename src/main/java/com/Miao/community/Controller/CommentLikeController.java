package com.Miao.community.Controller;

import com.Miao.community.DTO.CommentCreateDTO;
import com.Miao.community.DTO.CommentDTO;
import com.Miao.community.DTO.CommentLikeDTO;
import com.Miao.community.DTO.ResultDTO;
import com.Miao.community.exception.CustomizeErrorCode;
import com.Miao.community.model.Comment;
import com.Miao.community.model.User;
import com.Miao.community.service.CommentSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.certpath.CertId;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/13 0013 16:43
 * @description：评论点赞功能,不记录点赞人的id
 */
@Controller
public class CommentLikeController {
    @Autowired
    private CommentSevice commentSevice;

    @ResponseBody
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    public Object post(@RequestBody CommentLikeDTO commentLikeDTO,
                       HttpServletRequest request,
                       Model model){
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }

        commentSevice.incLikeCount(commentLikeDTO.getCommentID());
        return ResultDTO.successOf();
    }
}
