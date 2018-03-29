package com.vm.admin.service.dto;

import com.vm.base.service.dto.BaseDto;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/26.
 */
public class VmMenusDto extends BaseDto {

    private static final long serialVersionUID = 7247714666080613254L;

    private String menuName;
    private String keyProp;
    private Long pid;
    private Byte isLeaf;
    private String description;
    private String icon;
    private List<VmMenusDto> child;

    public String getKeyProp() {
        return keyProp;
    }

    public void setKeyProp(String keyProp) {
        this.keyProp = keyProp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<VmMenusDto> getChild() {
        return child;
    }

    public void setChild(List<VmMenusDto> child) {
        this.child = child;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Byte getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Byte isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
