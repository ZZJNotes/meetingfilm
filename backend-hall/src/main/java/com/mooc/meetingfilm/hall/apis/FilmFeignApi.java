package com.mooc.meetingfilm.hall.apis;

import com.mooc.meetingfilm.api.film.FilmFeignApis;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author zzj
 * @Date 2020/10/12 12:33
 * @Description film提供的接口服务
 */
@FeignClient(name = "film-service")
public interface FilmFeignApi extends FilmFeignApis {
}
