package com.mooc.meetingfilm.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.film.dao.entity.MoocFilmT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author jiangzh
 * @since 2020-10-04
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {

    DescribeFilmsRespVO describeFilmById(String filmId);

    IPage<DescribeFilmsRespVO> describeFilms(Page<DescribeFilmsRespVO> page);
}
