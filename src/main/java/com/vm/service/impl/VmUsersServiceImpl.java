package com.vm.service.impl;

import com.vm.dao.mapper.VmUsersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.po.VmUsersExample;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmUsersService;
import com.vm.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/28.
 */
@Service
public class VmUsersServiceImpl extends BaseService implements VmUsersService {
    @Autowired
    private VmUsersMapper vmUsersMapper;


    /**
     * 通过username获取user
     *
     * @param username
     * @return
     */
    private VmUsers getUserByUsername(String username) {
        //是否存在此username的user
        VmUsersExample example = new VmUsersExample();
        VmUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo(BasePo.Status.NORMAL.getCode());
        List<VmUsers> vmUsers = vmUsersMapper.selectByExample(example);
        if (isEmptyList(vmUsers)) {
            return null;
        }
        return vmUsers.get(0);
    }

    @Override
    public VmUsers userLogin(CustomVmUsers user) throws Exception {


        //user是否存在
        VmUsers dbUser = getUserByUsername(user.getUsername());
        eject(isNullObject(dbUser),
                "userLogin dbUser is not exits ! user is :" + dbUser);

        //密码错误
        eject(!dbUser.getPassword().equals(user.getPassword()),
                "userLogin password is error ! user is :" + user);


        return dbUser;
    }

    @Override
    public VmUsers getUserBasicInfo(Long userId) {
        eject(isNullObject(userId),
                "getUserBasicInfo userId is null! userId is:" + userId);

        //获取指定id的user

        VmUsers dbUser = vmUsersMapper.selectByPrimaryKey(userId);

        eject(isNullObject(dbUser) || BasePo.Status.isDeleted(dbUser.getStatus()),
                "getUserBasicInfo user is not exits! userId is:" + userId);

        //屏蔽相关信息
        coverUserSomeInfo(dbUser);

        return dbUser;
    }

    private void coverUserSomeInfo(VmUsers dbUser) {
        dbUser.setPassword("");
    }

    @Override
    public void updateUserBasicInfo(CustomVmUsers user) throws Exception {
        //user是否存在
        VmUsers dbUser = getUserByUsername(user.getUsername());
        eject(isNullObject(dbUser),
                "updateUserBasicInfo dbUser is not exits ! user is :" + dbUser);

        vmUsersMapper.updateByPrimaryKeySelective(makeVmUsers(user));
    }

    /**
     * 构建VmUsers
     * @param user
     * @return
     */
    private VmUsers makeVmUsers(CustomVmUsers user) {
        VmUsers vmUser = new VmUsers();
        vmUser.setBirthday(user.getBirthday());
        vmUser.setUpdateTime(DateUtil.unixTime().intValue());
        vmUser.setDescription(user.getDescription());
        vmUser.setSex(user.getSex());
        vmUser.setUsername(user.getUsername());
        return vmUser;
    }

}
