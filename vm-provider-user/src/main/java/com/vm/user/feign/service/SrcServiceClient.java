package com.vm.user.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "vm-provider-src")
public interface SrcServiceClient {


    @RequestMapping(value = "/src/img/cut", method = RequestMethod.POST)
    String cutUploadedImgFile(@RequestParam Map<String, Object> params);
}