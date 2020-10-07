package com.mooc.meetingfilm.cinema.controller.vo;

import lombok.Data;

/**
 * @Author zzj
 * @Date 2020/10/6 20:45
 * @Description
 */
@Data
public class DescribeCinemasRespVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;
}
