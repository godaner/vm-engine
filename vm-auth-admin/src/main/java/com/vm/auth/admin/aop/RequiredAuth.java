package com.vm.auth.admin.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhangKe on 2018/2/27.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredAuth {
    /**
     * 要求权限
     *
     * @return
     */
    String[] auths() default {};
}
