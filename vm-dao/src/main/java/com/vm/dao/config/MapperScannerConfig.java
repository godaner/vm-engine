package com.vm.dao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * mapper类扫描
 */
@Configuration
@MapperScan("com.vm.*.dao.mapper")
@AutoConfigureAfter(SqlMapConfig.class)
public class MapperScannerConfig {
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();  
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");  
        mapperScannerConfigurer.setBasePackage("com.vm.*.dao.mapper");
        return mapperScannerConfigurer;  
    }  
}  
