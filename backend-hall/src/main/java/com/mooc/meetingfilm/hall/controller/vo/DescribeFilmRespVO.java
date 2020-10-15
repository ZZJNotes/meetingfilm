package com.mooc.meetingfilm.hall.controller.vo;

import lombok.Data;

/**
 * @Author zzj
 * @Date 2020/10/12 11:25
 * @Description 根据主键获取影片信息对象
 */

@Data
public class DescribeFilmRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;


}