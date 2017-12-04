package com.vm.service.users.impl;

import com.vm.base.utils.DateTool;
import com.vm.dao.mapper.UsersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.Temple;
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

        Temple u = new Temple();
        u.setUsername(name);
        u.setPassword(password);
        u.setBirthday(DateTool.unixTime().intValue());
        u.setUpdateTime(DateTool.unixTime().intValue());
        u.setCreateTime(DateTool.unixTime().intValue());
        u.setDescription("厉害了");
        u.setSex(Temple.Sex.F.getCode());
        u.setStatus(BasePo.Status.NORMAL.getCode());
        usersMapper.insert(u);
    }
}
