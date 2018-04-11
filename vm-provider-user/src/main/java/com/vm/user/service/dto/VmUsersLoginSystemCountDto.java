package com.vm.user.service.dto;

import com.vm.base.service.dto.BaseDto;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public class VmUsersLoginSystemCountDto extends BaseDto{
    private String system;
    private Long number;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
