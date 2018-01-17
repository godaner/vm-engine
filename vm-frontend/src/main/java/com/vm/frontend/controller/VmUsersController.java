package com.vm.frontend.controller;

import com.google.common.collect.Maps;
import com.vm.base.util.ServiceController;
import com.vm.frontend.service.dto.UpdateHeadImgInfo;
import com.vm.frontend.service.dto.VmUsersDto;
import com.vm.frontend.service.inf.VmUsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class VmUsersController extends ServiceController<VmUsersService> {

    public static final String KEY_OF_ONLINE_USER = "ONLINE_USER";

    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogin(@RequestBody VmUsersDto vmUsersDto) throws Exception {

        VmUsersDto loginUser = service.userLogin(vmUsersDto);

        setSessionAttr(KEY_OF_ONLINE_USER, loginUser);

        return response.putData("user", loginUser).setMsg("登录成功");
    }

    @RequestMapping(value = "/regist", method = RequestMethod.PUT)
    @ResponseBody
    public Object userRegist(VmUsersDto user) throws Exception {

        VmUsersDto loginUser = service.userRegist(user);

        getSession().setAttribute(KEY_OF_ONLINE_USER, loginUser);

        return response.putData("user", loginUser);
    }

    @RequestMapping(value = "/online", method = RequestMethod.GET)
    @ResponseBody
    public Object getOnlineUser() throws Exception {
        Object user = null;

        if (!isNullObject(getSession())) {
            user = getSession().getAttribute(KEY_OF_ONLINE_USER);
        }
        if (isNullObject(user)) {
            return Maps.newHashMap();
        }
        //get db use
        user = service.getUserBasicInfo(((VmUsersDto) user).getId());
        //update session user
        setSessionAttr(KEY_OF_ONLINE_USER, user);

        return response.putData("user", user);
    }


    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    public @ResponseBody
    Object userLogout() throws Exception {

        getSession().removeAttribute(KEY_OF_ONLINE_USER);

        getSession().invalidate();

        return response;

    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserBasicInfo(@PathVariable("userId") Long userId) throws Exception {

        return response.putData("user", service.getUserBasicInfo(userId));
    }


    @RequestMapping(value = "/online", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateOnlineUserBasicInfo(@RequestBody VmUsersDto user) throws Exception {

        Object vmUsers = service.updateOnlineUserBasicInfo(user);

        setSessionAttr(KEY_OF_ONLINE_USER, vmUsers);

        return response.putData("user", vmUsers);
    }

    /**
     * 获取用户图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserImg(
            @PathVariable("fileId") Long fileId,
            @RequestParam("width") Integer width) throws Exception {
        service.sendUserImg(fileId, width, getResponse());
        return response;
    }


    /**
     * 上传用户临时(缓存)头像
     *
     * @return
     */
    @RequestMapping(value = "/img/temp", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadUserTempHeadImg(@RequestParam("img") MultipartFile headImg) throws Exception {
        VmUsersDto onlineUser = getSessionAttr(KEY_OF_ONLINE_USER);
        Long fileId = service.saveUserTempHeadImg(onlineUser.getId(), headImg);
        return response.putData("tempImgUrl", "/user/img/temp/" + fileId).
                putData("fileId", fileId);
    }


    /**
     * 获取{@link VmUsersController#uploadUserTempHeadImg}接口缓存的图片;
     *
     * @throws Exception
     */
    @RequestMapping(value = "/img/temp/{fileId}", method = RequestMethod.GET)
    @ResponseBody
    public void getUserTempHeadImg(@PathVariable("fileId") Long fileId) throws Exception {
        service.getUserTempHeadImg(fileId, getResponse());
    }

    /**
     * 更具已缓存图片更新用户头像<br/>
     * 实现缓存接口{@link VmUsersController#uploadUserTempHeadImg}
     *
     * @return
     */
    @RequestMapping(value = "/img", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUserHeadImg(@RequestBody UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        VmUsersDto onlineUser = getSessionAttr(KEY_OF_ONLINE_USER);
        onlineUser = service.updateUserHeadImg(onlineUser.getId(), updateHeadImgInfo);
        return response.putData("user", onlineUser).
                putData("newImgUrl", onlineUser.getImgUrl() + "?width=300");
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

