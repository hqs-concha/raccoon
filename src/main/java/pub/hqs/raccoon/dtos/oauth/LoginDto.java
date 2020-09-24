package pub.hqs.raccoon.dtos.oauth;

import lombok.Data;

/**
 * @program: raccoon
 * @description:
 * @author: hqs.pub
 * @create: 2020-09-22 15:32
 **/
@Data
public class LoginDto {
    private String username;
    private String password;
}
