package com.vm.movie.dao.qo;

import com.vm.dao.util.BaseQueryBean;

/**
 * Created by ZhangKe on 2018/3/19.
 */
public class VmFilmmakerQueryBean extends BaseQueryBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
