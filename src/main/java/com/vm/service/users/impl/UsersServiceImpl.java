package com.vm.service.users.impl;

import com.vm.common.utils.DateTool;
import com.vm.dao.mapper.UsersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.Users;
import com.vm.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangKe on 2017/11/30.
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public void add(String name, String password) {

        Users u = new Users();
        u.setUsername(name);
        u.setPassword(password);
        u.setBirthday(DateTool.unixTime().intValue());
        u.setUpdateTime(DateTool.unixTime().intValue());
        u.setCreateTime(DateTool.unixTime().intValue());
        u.setDescription("厉害了");
        u.setSex(Users.Sex.F.getCode());
        u.setStatus(BasePo.Status.NORMAL.getCode());
        usersMapper.insert(u);
    }
}
