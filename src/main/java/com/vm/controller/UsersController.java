package com.vm.controller;

import com.google.common.collect.ImmutableMap;
import com.vm.base.bo.Response;
import com.vm.base.utils.LoggerWrapper;
import com.vm.service.exception.VMRuntimeException;
import com.vm.service.exception.ValidateRuntimeException;
import com.vm.service.users.UsersService;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>
 * <br/>
 * <br/>
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/17 13:12
 */
@RestController
@RequestMapping("/users")
public class UsersController extends ServiceController<UsersService> {

    private LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(UsersController.class);

    @RequestMapping("/insert/{name}/{password}")
    public Map<Object,Object> insert(@PathVariable("name") String name, @PathVariable("password") String password){
        service.add(name,password);
        return ImmutableMap.of("k1","v1","k2","v2");
    }
//    @RequestMapping("/insert/{name}/{password}")
//    public Response insert(@PathVariable("name") String name, @PathVariable("password") String password){
//        logger.info("UsersController#insert name {}, password {}", name, password);
//
//        try {
//            service.add(name,password);
//        } catch (ValidateRuntimeException e) {
//            logger.error("UsersController#insert error name {} ,password {}, ",name,password);
//            response.setCode(e.getErrorCode().intValue());
//            response.setMsg(e.getMessage());
//            response.setMsg(e.getMessage());
//            e.printStackTrace();
//        }catch (Exception e) {
//            logger.error("UsersController#insert error name {} ,password {}, ",name,password);
//            response.setCode(VMRuntimeException.ErrorCode.UNKNOWN.getCode().intValue());
//            response.setMsg(VMRuntimeException.ErrorCode.UNKNOWN.getMsg());
//        }
//
//        logger.info("UsersController#insert response {}", response);
//        return response;
//    }
    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") Long id){
        int i = 0;
        i = i/i;
        return ImmutableMap.of("k1","v1","k2","v2");
    }
}
