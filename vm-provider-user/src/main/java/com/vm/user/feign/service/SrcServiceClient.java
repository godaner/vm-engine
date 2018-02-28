package com.vm.user.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Component
@FeignClient(value = "vm-provider-src")
public interface SrcServiceClient {

    @RequestMapping(value = "/src/img", method = RequestMethod.POST)
    String uploadImgFile(Map<String, Object> params);

    @RequestMapping(value = "/src/img/cut", method = RequestMethod.POST)
    String cutUploadedImgFile(Map<String, Object> params);
}