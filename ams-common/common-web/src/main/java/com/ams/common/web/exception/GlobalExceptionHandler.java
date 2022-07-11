package com.ams.common.web.exception;


import com.ams.common.exception.BizException;
import com.ams.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author： 乐哥聊编程(全平台同号)
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IllegalArgumentException.class)
    public <T> R<T> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常，异常原因：{}", e.getMessage(), e);
        return R.failed(e.getMessage());
    }


    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public <T> R<T> handleIllegalArgumentException(BizException e) {
        return R.failed(e.getResultCode());
    }

}
