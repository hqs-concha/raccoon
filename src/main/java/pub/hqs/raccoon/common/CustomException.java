package pub.hqs.raccoon.common;

/**
 * @program: raccoon
 * @description: exception
 * @author: hqs.pub
 * @create: 2020-09-23 15:14
 **/
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
