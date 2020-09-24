package pub.hqs.raccoon.services.users;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pub.hqs.raccoon.entities.users.RefreshToken;
import pub.hqs.raccoon.entities.users.User;
import pub.hqs.raccoon.mappers.users.RefreshTokenMapper;
import pub.hqs.raccoon.mappers.users.UserMapper;
import pub.hqs.raccoon.utils.IdUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @program: raccoon
 * @description:
 * @author: hqs.pub
 * @create: 2020-09-23 15:04
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private RefreshTokenMapper refreshTokenMapper;
    @Value("${appSetting.jwt.expire}")
    private Integer expire;

    public User verify(String username, String password){
        var query = new QueryWrapper<User>();
        query.eq("username", username);
        query.eq("password", password);
        var user = getOne(query);
        return user;
    }

    public String generateRefreshToken(String userId){
        var entity = new RefreshToken();
        entity.setId(IdUtils.generateUUID());
        entity.setCreateBy(userId);
        entity.setCreateAt(LocalDateTime.now());
        entity.setUserId(userId);
        entity.setToken(IdUtils.generateUUID());
        entity.setExpireTime(LocalDateTime.now().plusMinutes(expire));
        refreshTokenMapper.insert(entity);
        return entity.getToken();
    }
}
