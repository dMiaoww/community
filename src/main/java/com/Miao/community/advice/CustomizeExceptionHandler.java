package com.Miao.community.advice;

import com.Miao.community.DTO.ResultDTO;
import com.Miao.community.exception.CustomizeErrorCode;
import com.Miao.community.exception.CustomizeException;
import com.alibaba.fastjson.JSON;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author ：dMiaoWW
 * @date ：Created in 2019/11/5 0005 14:33
 * @description：异常处理
 */
@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) {
        ResultDTO resultDTO;
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            //返回json
            if (ex instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }

            try {
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json");
                response.setStatus(200);
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException IOe) {
            }
            return null;
        } else {
            //错误页面跳转
            if (ex instanceof CustomizeException) {
                model.addAttribute("errorMessage", ex.getMessage());
            } else {
                model.addAttribute("errorMessage", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
