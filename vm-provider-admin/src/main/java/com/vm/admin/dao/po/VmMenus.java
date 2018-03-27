package com.vm.admin.dao.po;

import com.vm.base.util.ByteConstant;
import com.vm.dao.util.BasePo;

public class VmMenus extends BasePo {
    private String menuName;
    private String keyProp;
    private Long pid;
    private Byte isLeaf;
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

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
    /**
     * 是否为叶子节点
     */
    public enum IsLeaf {
        YES(ByteConstant.ONE, "叶子节点"),
        NO(ByteConstant.TWO, "非叶子节点");

        Byte code;

        String msg;

        IsLeaf(Byte code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }


    }
}