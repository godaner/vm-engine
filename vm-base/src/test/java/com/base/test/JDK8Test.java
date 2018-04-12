package com.base.test;

import java.util.function.Function;

/**
 * Created by ZhangKe on 2018/4/12.
 */
public class JDK8Test {
    public static void main(String[] args) {
        //方法引用
        Fun fun = System.out::println;
        new Thread(() -> fun.print("9999")).start();

        //lamdal
        Function<Integer, String> converter = (s) -> String.valueOf(s);
        System.out.println(converter.apply(888));
    }
}
