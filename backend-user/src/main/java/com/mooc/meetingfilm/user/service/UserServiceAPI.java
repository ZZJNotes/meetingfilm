package com.mooc.meetingfilm.user.service;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @Author zzj
 * @Date 2020/10/3 18:33
 * @Description 用户接口
 */

public interface UserServiceAPI {

    String checkUserLogin(String username, String password) throws CommonServiceException;
}
