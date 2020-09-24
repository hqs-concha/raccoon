package pub.hqs.raccoon.entities.users;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: raccoon
 * @description: user table
 * @author: hqs.pub
 * @create: 2020-09-23 14:52
 **/
@Data
public class User {
    private String id;
    private String createBy;
    private LocalDateTime createAt;
    private String updateBy;
    private LocalDateTime updateAt;
    private String username;
    private String password;
    private String nickname;
    private Integer isDeleted;
}
