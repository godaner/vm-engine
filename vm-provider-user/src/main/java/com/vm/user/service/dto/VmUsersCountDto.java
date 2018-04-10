package com.vm.user.service.dto;

import com.vm.base.service.dto.BaseDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmUsersCountDto extends BaseDto{

    private Byte sex;

    private Long number;

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
