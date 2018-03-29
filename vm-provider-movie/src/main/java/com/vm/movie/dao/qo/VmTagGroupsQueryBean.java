package com.vm.movie.dao.qo;

import com.vm.dao.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/20.
 */
public class VmTagGroupsQueryBean extends BaseQueryBean{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
