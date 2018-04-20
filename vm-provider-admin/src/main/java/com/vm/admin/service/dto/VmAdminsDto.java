package com.vm.admin.service.dto;

import com.vm.base.service.dto.BaseDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmAdminsDto extends BaseDto{
    private String username;

    private String password;

    private Byte immutable;

    private String description;

    private List<VmMenusDto> menus;

    private String roleIds;


    //登录记录信息
    private String browser;
    private String city;
    private String country;
    private String dpi;
    private String ip;
    private String keyword;
    private String oldLink;
    private String page;
    private String province;
    private String system;
    private String title;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public List<VmMenusDto> getMenus() {
        return menus;
    }

    public void setMenus(List<VmMenusDto> menus) {
        this.menus = menus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getImmutable() {
        return immutable;
    }

    public void setImmutable(Byte immutable) {
        this.immutable = immutable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOldLink() {
        return oldLink;
    }

    public void setOldLink(String oldLink) {
        this.oldLink = oldLink;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public enum Result {

    }
}
