package com.vm.user.controller;

import com.vm.base.util.ServiceController;
import com.vm.user.aop.IgnoreExtendSessionLife;
import com.vm.user.aop.RequiredLogin;
import com.vm.user.resolver.OnlineUser;
import com.vm.user.service.dto.UpdateHeadImgInfo;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.inf.VmUsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class VmUsersController extends ServiceController<VmUsersService> {


    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogin(@RequestBody VmUsersDto vmUsersDto) throws Exception {

        VmUsersDto loginUser = service.userLogin(vmUsersDto);

//        setSessionAttr(KEY_OF_ONLINE_USER, loginUser);

        return response.putData("user", loginUser).setMsg("登录成功");
    }


    @RequestMapping(value = "/regist", method = RequestMethod.PUT)
    @ResponseBody
    public Object userRegist(VmUsersDto user) throws Exception {

        VmUsersDto loginUser = service.userRegist(user);

//        getSession().setAttribute(KEY_OF_ONLINE_USER, loginUser);

        return response.putData("user", loginUser);
    }

    /**
     * 试探用户是否在线;在线返回user，不在线抛出异常；未登录可以访问
     * @param onlineUser
     * @return
     * @throws Exception
     */
    @IgnoreExtendSessionLife
    @RequestMapping(value = "/feelerOnlineUser", method = RequestMethod.GET)
    @ResponseBody
    public Object feelerOnlineUser(@OnlineUser VmUsersDto onlineUser) throws Exception {
        boolean online = true;
        //防止出现问题
        if (onlineUser == null || onlineUser.getId() == null) {
            online = false;
        }
        return response.putData("online", online).putData("user",onlineUser);
    }

    /**
     * 客户端获取在线用户；未登录不能访问
     * @param onlineUser
     * @return
     * @throws Exception
     */
    @RequiredLogin
    @RequestMapping(value = "/online", method = RequestMethod.GET)
    @ResponseBody
    public Object getOnlineUser(@OnlineUser VmUsersDto onlineUser) throws Exception {

        return response.putData("user", onlineUser);
    }


    @RequiredLogin
    @RequestMapping(value = "/logout", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogout(@OnlineUser VmUsersDto onlineUser) throws Exception {

        service.userLogout(onlineUser.getToken());

        return response;

    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserBasicInfo(@PathVariable("userId") Long userId) throws Exception {

        return response.putData("user", service.getUserBasicInfo(userId));
    }


    @RequiredLogin
    @RequestMapping(value = "/online", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateOnlineUserBasicInfo(@OnlineUser VmUsersDto onlineUser,
                                            @RequestBody VmUsersDto user) throws Exception {

        user.setId(onlineUser.getId());

        Object vmUsers = service.updateOnlineUserBasicInfo(user);

//        setSessionAttr(KEY_OF_ONLINE_USER, vmUsers);

        return response.putData("user", vmUsers);
    }

    /**
     * 获取用户图片
     *
     * @return
     */
//    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
//    @ResponseBody
//    public Object getUserImg(
//            @PathVariable("fileId") Long fileId,
//            @RequestParam("width") Integer width) throws Exception {
//        service.sendUserImg(fileId, width, getResponse());
//        return response;
//    }


    /**
     * 上传用户临时(缓存)头像
     *
     * @return
     */
//    @RequiredLogin
//    @RequestMapping(value = "/img/temp", method = RequestMethod.POST)
//    @ResponseBody
//    public Object uploadUserTempHeadImg(@OnlineUser VmUsersDto onlineUser,
//                                        @RequestParam("img") MultipartFile headImg) throws Exception {
////        VmUsersDto onlineUser = getSessionAttr(KEY_OF_ONLINE_USER);
//        Map<String,String> res = service.saveUserTempHeadImg(onlineUser.getId(), headImg);
//        return response.putData("tempImgUrl", res.get("imgUrl")).
//                putData("fileId", res.get("fileId"));
//    }


    /**
     * 获取{@link VmUsersController#uploadUserTempHeadImg}接口缓存的图片;
     *
     * @throws Exception
     */
//    @RequestMapping(value = "/img/temp/{fileId}", method = RequestMethod.GET)
//    @ResponseBody
//    public void getUserTempHeadImg(@PathVariable("fileId") Long fileId) throws Exception {
//        service.getUserTempHeadImg(fileId, getResponse());
//    }

    /**
     * 更具已缓存图片更新用户头像<br/>
     *
     * @return
     */
    @RequiredLogin
    @RequestMapping(value = "/img", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUserHeadImg(@OnlineUser VmUsersDto onlineUser,
                                    @RequestBody UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        onlineUser = service.updateUserHeadImg(onlineUser.getId(), updateHeadImgInfo);
        return response.putData("user", onlineUser).
                putData("newImgUrl", onlineUser.getImgUrl() + "&width=300");
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

