package org.xq.gam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author 13797
 * @version v0.0.1
 * @date 2021/10/4 20:53
 */
@ControllerAdvice
@ResponseBody
public class ServiceExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ExceptionSpecification> exceptionHandler(ServiceException serviceException) {
        logger.error("服务内部异常", serviceException);
        return ResponseEntity.status(serviceException.getHttpStatus()).body(serviceException);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionSpecification> exceptionHandler(Exception e) {
        logger.error("未知异常", e);
        ExceptionEnum error = ExceptionEnum.SERVICE_ERROR;
        return ResponseEntity.status(error.getHttpStatus()).body(error);
    }


}
