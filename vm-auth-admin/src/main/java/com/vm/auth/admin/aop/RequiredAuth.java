package com.vm.auth.admin.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhangKe on 2018/2/27.
 */
@Target({ElementType.METHOD})// 可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface RequiredAuth {
    /**
     * 要求权限
     *
     * @return
     */
    String[] auths() default {};
}
