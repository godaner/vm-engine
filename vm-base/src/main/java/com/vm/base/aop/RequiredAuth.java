package com.vm.base.aop;

/**
 * Created by ZhangKe on 2018/2/27.
 */
public @interface RequiredAuth {
    /**
     * 要求权限
     *
     * @return
     */
    String[] auths() default {};
}
