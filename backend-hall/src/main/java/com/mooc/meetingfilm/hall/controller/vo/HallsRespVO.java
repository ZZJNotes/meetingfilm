package com.mooc.meetingfilm.hall.controller.vo;

import lombok.Data;

/**
 * @Author zzj
 * @Date 2020/10/12 11:24
 * @Description
 */

@Data
public class HallsRespVO {

    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;


}
