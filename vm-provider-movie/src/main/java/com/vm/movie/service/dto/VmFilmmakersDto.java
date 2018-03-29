package com.vm.movie.service.dto;

import com.vm.base.service.dto.BaseDto;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmFilmmakersDto extends BaseDto {

    private String name;

    private String alias;

    private String profession;

    private Byte bloodType;

    private Byte sex;

    private Integer birthday;

    private String country;

    private String description;

    private String imgUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Byte getBloodType() {
        return bloodType;
    }

    public void setBloodType(Byte bloodType) {
        this.bloodType = bloodType;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
