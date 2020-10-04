package com.mooc.meetingfilm.user.controller;

import com.mooc.meetingfilm.user.controller.vo.LoginReqVO;
import com.mooc.meetingfilm.user.service.UserServiceAPI;
import com.mooc.meetingfilm.user.service.UserServiceImpl;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author zzj
 * @Date 2020/10/3 16:00
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceAPI userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO reqVO) throws CommonServiceException{
        // 数据验证,验证用户名和密码是否为空
        reqVO.checkParam();
        // 验证用户名和密码是否正确
        String userId = userService.checkUserLogin(reqVO.getUsername(), reqVO.getPassword());
        // 验证通过之后，生成 JWT
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);

        // randomKey token
        HashMap<String, String> result = new HashMap<>();
        result.put("randomKey", randomKey);
        result.put("token", token);

        return BaseResponseVO.success(result);
    }
}
