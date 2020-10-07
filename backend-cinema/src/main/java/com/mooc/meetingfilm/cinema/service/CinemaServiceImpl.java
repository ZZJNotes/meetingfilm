package com.mooc.meetingfilm.cinema.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.cinema.controller.vo.CinemaSavedReqVO;
import com.mooc.meetingfilm.cinema.controller.vo.DescribeCinemasRespVO;
import com.mooc.meetingfilm.cinema.dao.entity.MoocCinemaT;
import com.mooc.meetingfilm.cinema.dao.mapper.MoocCinemaTMapper;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.mooc.meetingfilm.utils.util.ToolUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zzj
 * @Date 2020/10/6 20:10
 * @Description
 */
@Service
public class CinemaServiceImpl implements CinemaServiceAPI {

    @Resource
    private MoocCinemaTMapper cinemaTMapper;

    // 保存影院
    @Override
    public void saveCinema(CinemaSavedReqVO reqVO) throws CommonServiceException {
        MoocCinemaT cinemaT = new MoocCinemaT();

        cinemaT.setCinemaName(reqVO.getCinemaName());
        cinemaT.setCinemaPhone(reqVO.getCinemaTele());
        cinemaT.setBrandId(ToolUtils.str2Int(reqVO.getBrandId()));
        cinemaT.setAreaId(ToolUtils.str2Int(reqVO.getAreaId()));
        cinemaT.setHallIds(reqVO.getHallTypeIds());
        cinemaT.setImgAddress(reqVO.getCinemaImgAddress());
        cinemaT.setCinemaAddress(reqVO.getCinemaAddress());
        cinemaT.setMinimumPrice(ToolUtils.str2Int(reqVO.getCinemaPrice()));

        cinemaTMapper.insert(cinemaT);

    }

    // 获取影院列表
    @Override
    public IPage<DescribeCinemasRespVO> describeCinemas(int pageSize, int nowPage) throws CommonServiceException {

        // 查询实体对象，然后与表现层对象进行交互
        Page<MoocCinemaT> page = new Page<>(nowPage, pageSize);
        IPage<MoocCinemaT> moocCinemaTIPage = cinemaTMapper.selectPage(page, null);


        return cinemaTMapper.describeCinemas(page);
    }


}
