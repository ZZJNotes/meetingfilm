package com.mooc.meetingfilm.film.controller;

import com.google.common.collect.Maps;
import com.mooc.meetingfilm.api.film.vo.DescribeFilmsRespVO;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.controller.vo.FilmSavedReqVO;
import com.mooc.meetingfilm.film.service.FilmServiceAPI;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zzj
 * @Date 2020/10/4 22:01
 * @Description 影片模块表现层
 */

@RestController
@RequestMapping("/films")
public class FilmController {

    @Resource
    private FilmServiceAPI filmServiceAPI;



    // 演员列表查询
    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public BaseResponseVO describeActors(BasePageVO basePageVO) throws CommonServiceException{
        // 参数校验
        basePageVO.checkParam();
        // 调用逻辑层，获取返回参数，即获取演员列表
        IPage<DescribeActorsRespVO> actors = filmServiceAPI.describeActors(basePageVO.getNowPage(), basePageVO.getPageSize());
        Map<String, Object> result = describePageResult(actors, "actors");

        return BaseResponseVO.success(result);
    }

    // 根据电影编号查询电影信息接口
    @RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
    public BaseResponseVO describeFilmById(@PathVariable String filmId) throws CommonServiceException{
        DescribeFilmsRespVO describeFilmRespVO = filmServiceAPI.describeFilmById(filmId);

        if (describeFilmRespVO == null) {
            return BaseResponseVO.success();
        } else {
            return BaseResponseVO.success(describeFilmRespVO);
        }
    }

    //  影片新增接口
    @PostMapping("/film:add")
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) throws CommonServiceException{

        filmServiceAPI.saveFilm(filmSavedReqVO);

        return BaseResponseVO.success();
    }
    // 浏览影片列表接口
    @RequestMapping(value ="", method = RequestMethod.GET)
    public BaseResponseVO decribeFilms(HttpServletRequest request, BasePageVO basePageVO) throws CommonServiceException{
        // 检查入参
        basePageVO.checkParam();
        // 调用逻辑层，获取返回参数
        IPage<DescribeFilmsRespVO> results = filmServiceAPI.describeFilms(basePageVO.getNowPage(), basePageVO.getPageSize());
        Map<String, Object> films = describePageResult(results, "films");
        return BaseResponseVO.success(films);
    }

    // 获取分页对象的公共接口
    public Map<String ,Object> describePageResult(IPage page, String title){
        HashMap<String, Object> result = Maps.newHashMap();

        result.put("totalSize",page.getTotal());
        result.put("totalPages",page.getPages());
        result.put("pageSize",page.getSize());
        result.put("nowPage",page.getCurrent());

        result.put(title, page.getRecords());

        return result;

    }

}
