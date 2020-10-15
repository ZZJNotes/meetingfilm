package com.mooc.meetingfilm.show.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.feign
 * @description :
 **/
@Service
public class FallbackFactory implements feign.hystrix.FallbackFactory {

    @Override
    public ProviderApi create(Throwable throwable) {
        return new ProviderApi() {
            @Override
            public String feignTest(String message) {
                return "invokerProviderController FallbackFactory message="+message;
            }

            @Override
            public String invokerProviderController(String message) {
                return "invokerProviderController FallbackFactory message="+message;
            }
        };
    }

}
