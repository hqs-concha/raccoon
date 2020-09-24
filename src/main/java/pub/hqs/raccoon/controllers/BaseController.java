package pub.hqs.raccoon.controllers;

import org.springframework.http.HttpStatus;
import pub.hqs.raccoon.dtos.ApiResult;

/**
 * @program: raccoon
 * @description: base controller
 * @author: hqs.pub
 * @create: 2020-09-23 14:10
 **/
public abstract class BaseController {

    protected ApiResult ok(Object data){
        var timestamp = System.currentTimeMillis();
        return new ApiResult(null, timestamp, data, HttpStatus.OK.value());
    }

    protected ApiResult badRequest(String message){
        return badRequest(message,null);
    }

    protected ApiResult badRequest(String message, Object data){
        var timestamp = System.currentTimeMillis();
        return new ApiResult(message, timestamp, data, HttpStatus.BAD_REQUEST.value());
    }
}
