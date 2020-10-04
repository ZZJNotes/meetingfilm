package com.mooc.meetingfilm.film.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.dao.mapper.MoocActorTMapper;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zzj
 * @Date 2020/10/4 22:42
 * @Description 影片模块实现层
 */
@Service
public class FilmServiceImpl implements FilmServiceAPI {

    @Resource
    private MoocActorTMapper actorTMapper;

    @Override
    public IPage<DescribeActorsRespVO> describeActors(int nowPage, int pageSize) throws CommonServiceException {


        return actorTMapper.describeActors(new Page<>(nowPage, pageSize));
    }
}
