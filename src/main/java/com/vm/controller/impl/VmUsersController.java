package com.vm.controller.impl;

import com.vm.controller.base.ServiceController;
import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.inf.VmUsersService;
import com.vm.validator.group.VmUsersGroups;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class VmUsersController extends ServiceController<VmUsersService> {
    public static final String KEY_OF_ONLINE_USER = "ONLINE_USER";

    /*********************************前端*********************************/
    @RequestMapping("/login")
    public @ResponseBody
    Object userLogin(@Validated(value = {VmUsersGroups.UserLogin.class}) CustomVmUsers user,
                     BindingResult result) throws Exception {

        VmUsers loginUser = service.userLogin(user);

        getSession().setAttribute(KEY_OF_ONLINE_USER, loginUser);

        response.putData("loginUser", loginUser);

        return response;
    }

    @RequestMapping("/online")
    public @ResponseBody
    Object getOnlineUser() throws Exception {
        Object user = null;

        if (!isNullObject(getSession())) {
            user = getSession().getAttribute(KEY_OF_ONLINE_USER);
        }
        response.putData("user", user);


        return response;
    }

    @RequestMapping("/logout")
    public @ResponseBody
    Object userLogout() throws Exception {

        getSession().removeAttribute(KEY_OF_ONLINE_USER);

        return response;

    }

    @RequestMapping("/{userId}")
    public @ResponseBody
    Object getUserBasicInfo(@PathVariable("userId") Long userId) throws Exception {

        VmUsers user = service.getUserBasicInfo(userId);

        response.putData("user", user);

        return response;
    }

    @RequestMapping("/update")
    public @ResponseBody
    Object updateUserBasicInfo(@Validated(value = {VmUsersGroups.UpdateUserBasicInfo.class}) CustomVmUsers user,
                               BindingResult result) throws Exception {

        service.updateUserBasicInfo(user);

        return response;
    }

    /**
     * 获取用户图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{userId}", method = RequestMethod.GET)
    public void getUserImg(@PathVariable("userId") Long userId, VmMoviesQueryBean query) throws Exception {
        service.sendUserImg(userId, query, getResponse());

    }

    /*********************************后端*********************************/

}

