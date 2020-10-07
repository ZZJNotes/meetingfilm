package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @Author zzj
 * @Date 2020/10/6 20:09
 * @Version V1.0
 */

public interface CinemaServiceAPI {
    // 保存影院
    void saveCinema(CinemaSavedReqVO cinemaSavedReqVO) throws CommonServiceException;
    // 获取影院列表
    IPage<DescribeCinemasRespVO> describeCinemas(int pageSize, int nowPage) throws CommonServiceException;
}
