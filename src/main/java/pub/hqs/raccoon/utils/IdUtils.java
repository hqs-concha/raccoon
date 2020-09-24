package pub.hqs.raccoon.utils;

import java.util.UUID;

/**
 * @program: raccoon
 * @description: IdUtils
 * @author: hqs.pub
 * @create: 2020-09-23 13:29
 **/
public class IdUtils {
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
