package com.vm.movie.dao.po;

import com.vm.dao.util.BasePo;

public class VmCountrys extends BasePo {

    private String code;

    private String nameChinese;

    private String nameEnglish;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getNameChinese() {
        return nameChinese;
    }

    public void setNameChinese(String nameChinese) {
        this.nameChinese = nameChinese == null ? null : nameChinese.trim();
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish == null ? null : nameEnglish.trim();
    }

}