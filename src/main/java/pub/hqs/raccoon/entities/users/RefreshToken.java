package pub.hqs.raccoon.entities.users;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: raccoon
 * @description: refresh token
 * @author: hqs.pub
 * @create: 2020-09-23 18:27
 **/
@Data
public class RefreshToken {
    private String id;
    private String createBy;
    private LocalDateTime createAt;
    private String userId;
    private String token;
    private LocalDateTime expireTime;
}
