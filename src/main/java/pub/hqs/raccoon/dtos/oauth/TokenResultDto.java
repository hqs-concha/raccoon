package pub.hqs.raccoon.dtos.oauth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: raccoon
 * @description: token result
 * @author: hqs.pub
 * @create: 2020-09-23 18:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResultDto {
    private String token;
    private String refreshToken;
    private String type;
    private Integer expireIn;
}
