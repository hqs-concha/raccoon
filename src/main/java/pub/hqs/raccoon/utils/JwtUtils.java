package pub.hqs.raccoon.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

/**
 * @program: raccoon
 * @description: JwtUtils
 * @author: hqs.pub
 * @create: 2020-09-23 12:43
 **/
@Component
public class JwtUtils {

    @Value("${appSetting.jwt.secret}")
    public String secret;

    @Value("${appSetting.jwt.expire}")
    public Integer expire;

    public Boolean verify(String token){
        var alg = Algorithm.HMAC256(secret);
        var verifier = JWT.require(alg).build();
        var jwt = verifier.verify(token);
        var expireAt = jwt.getExpiresAt();
        return expireAt.after(new Date());
    }

    public String sign(String userId, HashMap<String, Object> claims){
        // 给定一个算法，如HmacSHA-256
        var alg = Algorithm.HMAC256(secret);
        var currentTime = new Date();

        var jwt = JWT.create()
                .withIssuer("Raccoon") // 发行者
                .withSubject(userId) // 用户身份标识
                .withAudience("Web") // 用户单位
                .withIssuedAt(currentTime) // 签发时间
                .withNotBefore(currentTime)
                .withExpiresAt(new Date(currentTime.getTime() + expire*60*1000L))
                .withJWTId(IdUtils.generateUUID()) // 分配JWT的ID
                .withClaim("uid",userId);

        for(var key : claims.keySet()){
            jwt.withClaim(key, claims.get(key).toString());
        }

        var token = jwt.sign(alg);
        return token;
    }

    public String getClaim(String token, String key) {
        try {
            var jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
