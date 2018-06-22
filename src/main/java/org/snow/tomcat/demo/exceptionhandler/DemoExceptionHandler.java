package org.snow.tomcat.demo.exceptionhandler;

import org.framework.basic.system.BaseResponse;
import org.framework.basic.system.ResponseEntity;
import org.framework.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA.
 * User: snowxuyu
 * Date: 2017-8-24
 * Time: 21:58
 */
@RestControllerAdvice
public class DemoExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({BaseException.class})
    public ResponseEntity excetionHandler(BaseException e) {
        logger.error("Controller BaseException:{}", e);
        return BaseResponse.buildError("54000001", e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception e) {
        logger.error("Controller Exception:{}", e);
        return BaseResponse.buildError("54000000", "系统异常");
    }
}
