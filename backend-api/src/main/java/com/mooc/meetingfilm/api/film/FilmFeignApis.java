package com.mooc.meetingfilm.api.film;

import com.mooc.meetingfilm.api.film.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author zzj
 * @Date 2020/10/12 16:07
 * @Description
 */

public interface FilmFeignApis {

    // 对外暴露的接口服务
    @RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
    public BaseResponseVO<DescribeFilmsRespVO> describeFilmById(@PathVariable String filmId) throws CommonServiceException;
}
