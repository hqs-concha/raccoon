package pub.hqs.raccoon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pub.hqs.raccoon.common.CustomException;
import pub.hqs.raccoon.dtos.ApiResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: raccoon
 * @description: ExceptionController
 * @author: hqs.pub
 * @create: 2020-09-23 15:17
 **/
@RestControllerAdvice
public class ExceptionController extends BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public ApiResult handleCustomException(CustomException ex){
        return badRequest(ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResult globalException(HttpServletRequest request, Throwable ex) {
        return badRequest(ex.getMessage(), null);
    }
}
