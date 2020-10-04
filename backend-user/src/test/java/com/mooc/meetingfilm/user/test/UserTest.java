package com.mooc.meetingfilm.user.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mooc.meetingfilm.user.BackendUserApplicationTests;
import com.mooc.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.mooc.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import com.mooc.meetingfilm.utils.util.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Wrapper;

/**
 * @Author zzj
 * @Date 2020/10/4 10:07
 * @Description
 */

public class UserTest extends BackendUserApplicationTests {

    @Resource
    private MoocBackendUserTMapper userMapper;

    @Test
    public void deletTest(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.between("UUID",49,58);

        userMapper.delete(wrapper);
    }

    @Test
    public void insertTest(){
        MoocBackendUserT user = new MoocBackendUserT();

        for (int i = 0; i < 10; i++) {
            user.setUserName("admin" + i);
            user.setUserPwd(MD5Util.encrypt("admin" + i));
            user.setUserPhone("1112223334" + i);

            userMapper.insert(user);
        }
    }

}
