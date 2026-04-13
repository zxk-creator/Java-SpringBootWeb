package com.kunkun.springwebone.proxy;

import com.kunkun.springwebone.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 直接接住所有异常
@RestControllerAdvice
public class exceptionProxy {

    // 可以在这里写处理多个异常的方法，防止一直提示联系管理员。
    /**
    @ExceptionHandler(Exception.class)
    public Result<> handleException(Exception e)
    {
        e.printStackTrace();
        return Result.error();
    }
    **/
}
