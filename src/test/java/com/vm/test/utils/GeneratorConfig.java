package com.vm.test.utils;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Title:GeneratorConfig
 * <p>
 * Description:mybatis逆向生成mapper接口,mapperxml,bean
 * <p>
 *
 * @author Kor_Zhang
 * @version 1.0
 * @date 2017年9月5日 下午4:44:27
 */
public class GeneratorConfig {

    /**
     * 生成mybatis操作文件入口
     * @throws Exception
     */
    @Test
    public void mybatisGenerator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
//        String path = GeneratorConfig.class.getResource("").getPath() + "generatorConfig.xml";

        String path = GeneratorConfig.class.getClassLoader().getResource("./").getPath()+"/generatorConfig.xml";
        // 指定逆向工程配置文件
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }


}