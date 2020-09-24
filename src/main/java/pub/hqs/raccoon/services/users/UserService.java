package pub.hqs.raccoon.services.users;

import com.baomidou.mybatisplus.extension.service.IService;
import pub.hqs.raccoon.entities.users.User;

public interface UserService extends IService<User> {
    User verify(String username, String password);
    String generateRefreshToken(String userId);
}
