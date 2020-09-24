package pub.hqs.raccoon.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pub.hqs.raccoon.dtos.ApiResult;
import pub.hqs.raccoon.dtos.oauth.LoginDto;
import pub.hqs.raccoon.dtos.oauth.TokenResultDto;
import pub.hqs.raccoon.services.users.UserService;
import pub.hqs.raccoon.utils.JwtUtils;

import java.util.HashMap;

/**
 * @program: raccoon
 * @description:
 * @author: hqs.pub
 * @create: 2020-09-22 15:10
 **/
@CrossOrigin
@RestController
@RequestMapping("/oauth")
@Api(tags = "账号相关")
public class AccountController extends BaseController {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;
    @Value("${appSetting.jwt.expire}")
    private Integer expire;

    @PostMapping("login")
    @ApiOperation("登录")
    public ApiResult login(@RequestBody LoginDto dto){
        var user = userService.verify(dto.getUsername(), dto.getPassword());
        if(user == null) return badRequest("用户名或密码不正确");

        var claims = new HashMap<String, Object>();
        claims.put("username", user.getUsername());
        claims.put("nickname", user.getNickname());
        var token = jwtUtils.sign(user.getId(), claims);

        var refreshToken = userService.generateRefreshToken(user.getId());
        var result = new TokenResultDto(token, refreshToken, "Bearer", expire*60);
        return ok(result);
    }
}
