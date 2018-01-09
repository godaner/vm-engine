package com.vm.frontend.controller;

import com.google.common.collect.ImmutableMap;
import com.vm.base.utils.ServiceController;
import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.frontend.service.inf.VmUsersService;
import com.vm.dao.validator.group.VmUsersGroups;
import io.swagger.annotations.*;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
@Api(value = "用户相关接口", description = "用户的登录，注册，在线用户的获取等")
public class VmUsersController extends ServiceController<VmUsersService> {
    public static final String KEY_OF_ONLINE_USER = "ONLINE_USER";

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "/regist", method = RequestMethod.PUT)
    public @ResponseBody
    Object userRegist(@Validated(value = {VmUsersGroups.UserRegist.class}) @RequestBody CustomVmUsers user,
                      BindingResult result) throws Exception {

        VmUsers loginUser = service.userRegist(user);

        getSession().setAttribute(KEY_OF_ONLINE_USER, loginUser);

        response.putData("user", loginUser);

        return response;
    }

    @RequestMapping(value = "/online", method = RequestMethod.GET)
    public @ResponseBody
    Object getOnlineUser() throws Exception {
        Object user = null;

        if (!isNullObject(getSession())) {
            user = getSession().getAttribute(KEY_OF_ONLINE_USER);
        }
        //update use from db
        if (!isNullObject(user)) {
            user = service.getUserBasicInfo(((VmUsers) user).getId());
        }
        response.putData("user", user);


        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public @ResponseBody
    Object userLogin(@Validated(value = {VmUsersGroups.UserLogin.class}) @RequestBody CustomVmUsers user,
                     BindingResult result) throws Exception {

        VmUsers loginUser = service.userLogin(user);

        setSessionAttr(KEY_OF_ONLINE_USER, loginUser);

        response.putData("user", loginUser);

        return response;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    public @ResponseBody
    Object userLogout() throws Exception {

        getSession().removeAttribute(KEY_OF_ONLINE_USER);

        getSession().invalidate();

        return response;

    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getUserBasicInfo(@PathVariable("userId") Long userId) throws Exception {

        VmUsers user = service.getUserBasicInfo(userId);

        response.putData("user", user);

        return response;
    }


    @RequestMapping(value = "/online/update", method = RequestMethod.PUT)
    public @ResponseBody
    Object updateOnlineUserBasicInfo(@Validated(value = {VmUsersGroups.UpdateUserBasicInfo.class}) CustomVmUsers user,
                                     BindingResult result) throws Exception {

        Object vmUsers = service.updateOnlineUserBasicInfo(user);

        setSessionAttr(KEY_OF_ONLINE_USER, vmUsers);

        return ImmutableMap.of("user", vmUsers);
    }

    /**
     * 获取用户图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
    public void getUserImg(@PathVariable("fileId") Long fileId, VmMoviesQueryBean query) throws Exception {
        service.sendUserImg(fileId, query, getResponse());

    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public @ResponseBody
//    Object updateOnlineUserBasicInfo(@Validated(value = {VmUsersGroups.UpdateUserBasicInfo.class}) CustomVmUsers user,
//                               BindingResult result) throws Exception {
//
//        VmUsers vmUsers = service.updateOnlineUserBasicInfo(user);
//
//        response.putData("user",vmUsers);
//
//        return response;
//    }
}

