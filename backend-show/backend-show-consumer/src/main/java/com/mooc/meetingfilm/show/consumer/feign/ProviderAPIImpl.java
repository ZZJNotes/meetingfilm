package com.mooc.meetingfilm.show.consumer.feign;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProviderAPIImpl implements ProviderApi{
    @Override
    public String feignTest(String message) {
        return "consumer" + "自己实现的："+ message;
    }

    @Override
    public String invokerProviderController(String message) {
        return null;
    }

//    @Override
//    public String providerPost(String author, String providerId, UserModel userModel) {
//        return null;
//    }
}
