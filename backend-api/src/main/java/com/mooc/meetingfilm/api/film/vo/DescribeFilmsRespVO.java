package com.mooc.meetingfilm.api.film.vo;

import lombok.Data;

/**
 * @Author zzj
 * @Date 2020/10/4 23:53
 * @Description 查询影片列表接口返回对象
 */
@Data
public class DescribeFilmsRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;
}
