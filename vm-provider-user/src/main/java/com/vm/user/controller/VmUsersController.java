package com.vm.user.controller;


import com.vm.auth.admin.aop.RequiredAdminLogin;
import com.vm.auth.admin.aop.RequiredAuth;
import com.vm.auth.user.aop.IgnoreExtendUserSessionLife;
import com.vm.auth.user.aop.RequiredUserLogin;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.resolver.OnlineUser;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.inf.VmUsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/28.
 */
@Controller
@RequestMapping("/")
@Scope("prototype")
public class VmUsersController extends ServiceController<VmUsersService> {
    /*********************************用户端****************************/

    @RequestMapping(value = "/user/login", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogin(@RequestBody VmUsersDto vmUsersDto) throws Exception {

        VmUsersDto loginUser = service.userLogin(vmUsersDto);

        return response.putData("user", loginUser).setMsg("登录成功");
    }


    @RequestMapping(value = "/user/regist", method = RequestMethod.PUT)
    @ResponseBody
    public Object userRegist(VmUsersDto user) throws Exception {

        VmUsersDto loginUser = service.userRegist(user);

        return response.putData("user", loginUser);
    }

    /**
     * 试探用户是否在线;在线返回user，不在线抛出异常；未登录可以访问
     *
     * @param onlineUser
     * @return
     * @throws Exception
     */
    @IgnoreExtendUserSessionLife
    @RequestMapping(value = "/user/feelerOnlineUser", method = RequestMethod.GET)
    @ResponseBody
    public Object feelerOnlineUser(@OnlineUser VmUsersDto onlineUser) throws Exception {
        boolean online = true;
        //防止出现问题
        if (onlineUser == null || onlineUser.getId() == null) {
            online = false;
        }
        return response.putData("online", online).putData("user", onlineUser);
    }

    /**
     * 客户端获取在线用户；未登录不能访问
     *
     * @param onlineUser
     * @return
     * @throws Exception
     */
    @RequiredUserLogin
    @RequestMapping(value = "/user/online", method = RequestMethod.GET)
    @ResponseBody
    public Object getOnlineUser(@OnlineUser VmUsersDto onlineUser) throws Exception {

        return response.putData("user", onlineUser);
    }


    @RequiredUserLogin
    @RequestMapping(value = "/user/logout", method = RequestMethod.PUT)
    @ResponseBody
    public Object userLogout(@OnlineUser VmUsersDto onlineUser) throws Exception {

        service.userLogout(onlineUser.getToken());

        return response;

    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserBasicInfo(@PathVariable("userId") Long userId) throws Exception {

        return response.putData("user", service.getUserBasicInfo(userId));
    }


    @RequiredUserLogin
    @RequestMapping(value = "/user/online", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateOnlineUserBasicInfo(@OnlineUser VmUsersDto onlineUser,
                                            @RequestBody VmUsersDto user) throws Exception {

        user.setId(onlineUser.getId());

        Object vmUsers = service.updateOnlineUserBasicInfo(user);


        return response.putData("user", vmUsers);
    }



    /**
     * 更具已缓存图片更新在线用户头像<br/>
     *
     * @return
     */
    @RequiredUserLogin
    @RequestMapping(value = "/user/online/img", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUserHeadImg(@OnlineUser VmUsersDto onlineUser,
                                    @RequestBody UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        onlineUser = service.updateUserHeadImg(onlineUser.getId(), updateHeadImgInfo);
        return response.putData("user", onlineUser).
                putData("imgUrl", onlineUser.getImgUrl());
    }


    /*********************************管理端****************************/
    @RequiredAdminLogin
    @RequiredAuth(auths = {"user:select"})
    @RequestMapping(value = "/user/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object userList(VmUserQueryBean query, PageBean page) throws Exception {

        List<VmUsersDto> list = service.userList(query, page);
        Long total = service.userListTotal(query, page);
        return response.putData("list", list).putData("total", total);
    }

    @RequiredAdminLogin
    @RequiredAuth(auths = {"user:add"})
    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addUser(VmUsersDto vmUsersDto) throws Exception {
        return response.putData("user", service.addUser(vmUsersDto));
    }

    @RequiredAdminLogin
    @RequiredAuth(auths = {"user:edit"})
    @RequestMapping(value = "/user/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editUser(VmUsersDto vmUsersDto) throws Exception {
        return response.putData("user", service.editUser(vmUsersDto));
    }

    @RequiredAdminLogin
    @RequiredAuth(auths = {"user:delete"})
    @RequestMapping(value = "/user/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUser(@RequestBody VmUsersDto vmUsersDto) throws Exception {
        service.deleteUser(vmUsersDto);
        return response;
    }

    /**
     * 更具已缓存图片更新用户头像<br/>
     *
     * @return
     */
    @RequiredAdminLogin
    @RequestMapping(value = "/user/img", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUserHeadImg(UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        VmUsersDto usersDto = service.updateUserHeadImg(updateHeadImgInfo);
        return response.putData("user", usersDto).
                putData("imgUrl", usersDto.getImgUrl());
    }


}

