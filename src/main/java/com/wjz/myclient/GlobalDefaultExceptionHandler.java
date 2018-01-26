package com.wjz.myclient;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jingzhi.wu on 2018/1/22.
 */
@ControllerAdvice
@RestController
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e)  {
        //打印异常信息：
        e.printStackTrace();
        System.out.println("client GlobalDefaultExceptionHandler.defaultErrorHandler()");
        return e.getMessage();
    }
}
