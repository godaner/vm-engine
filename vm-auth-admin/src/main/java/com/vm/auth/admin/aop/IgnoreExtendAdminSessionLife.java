package com.vm.auth.admin.aop;

/**
 * Created by ZhangKe on 2018/2/27.
 * 请求该注解的controller将不会拓展其session的生命周期
 */
public @interface IgnoreExtendAdminSessionLife {
}
