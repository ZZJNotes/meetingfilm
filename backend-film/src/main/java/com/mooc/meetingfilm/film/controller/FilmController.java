package com.mooc.meetingfilm.film.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.dao.mapper.MoocActorTMapper;
import com.mooc.meetingfilm.utils.common.vo.BasePageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import com.sun.javafx.collections.MappingChange;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    private MoocActorTMapper actorTMapper;

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public BaseResponseVO describeActors(BasePageVO basePageVO) throws CommonServiceException{
        // 参数校验
        basePageVO.checkParam();
        // 调用逻辑层，获取返回参数，即获取演员列表
        IPage<DescribeActorsRespVO> actors = actorTMapper.describeActors(new Page<>(basePageVO.getNowPage(), basePageVO.getPageSize()));
        Map<String, Object> result = describePageResult(actors, "actors");

        return BaseResponseVO.success(result);
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
