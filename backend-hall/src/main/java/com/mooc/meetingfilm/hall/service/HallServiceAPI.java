package com.mooc.meetingfilm.hall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.hall.controller.vo.HallSavedReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsReqVO;
import com.mooc.meetingfilm.hall.controller.vo.HallsRespVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @Author zzj
 * @Date 2020/10/12 11:16
 * @Description
 */

public interface HallServiceAPI {

    // 保存影厅信息
    void saveHall(HallSavedReqVO hallSavedReqVO) throws CommonServiceException;

    // 获取全部播放厅接口
    IPage<HallsRespVO> describeHalls(HallsReqVO hallsReqVO) throws  CommonServiceException;


}
