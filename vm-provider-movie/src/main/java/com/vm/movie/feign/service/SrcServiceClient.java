package com.vm.movie.feign.service;

import com.vm.movie.feign.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Component
@FeignClient(value = "vm-provider-src",configuration= FeignConfig.class)
public interface SrcServiceClient {


    @RequestMapping(value = "/src/img/cut", method = RequestMethod.POST)
    String cutUploadedImgFile(@RequestParam Map<String, Object> params);

    @RequestMapping(value = "/src/video", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadVideo(@RequestPart("file")MultipartFile file);

}