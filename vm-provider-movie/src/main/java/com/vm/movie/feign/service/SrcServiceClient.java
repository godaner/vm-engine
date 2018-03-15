package com.vm.movie.feign.service;

import com.vm.movie.feign.config.LogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "vm-provider-src",configuration= LogConfiguration.class)
public interface SrcServiceClient {


    @RequestMapping(value = "/src/img/cut", method = RequestMethod.POST)
    String cutUploadedImgFile(@RequestParam Map<String, Object> params);
}