package pub.hqs.raccoon.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: raccoon
 * @description:
 * @author: hqs.pub
 * @create: 2020-09-22 15:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult {
    private String message;
    private long timestamp;
    private Object data;
    private int code;
}
