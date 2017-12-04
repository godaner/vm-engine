package com.vm.base.utils;


import com.vm.controller.TempleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZhangKe on 2017/11/30.
 */
public class LoggerWrapper {
    private static Logger logger = null;
    private static LoggerWrapper loggerWrapper;
    public static LoggerWrapper newLoggerWrapper(Class<?> clazz) {
        loggerWrapper = new LoggerWrapper();
        loggerWrapper.logger = LoggerFactory.getLogger(TempleController.class);
        return loggerWrapper;
    }
    private final static String LINE = "===============================================";
    private final static String START_LINE = ">"+LINE;
    private final static String END_LINE = "<"+LINE;
    private void prinErrorStartLine(){
        loggerWrapper.logger.error(START_LINE);
    }
    private void prinErrorEndtLine(){
        loggerWrapper.logger.error(END_LINE);
    }
    private void prinInfoStartLine(){
        loggerWrapper.logger.info(START_LINE);
    }
    private void prinInfoEndtLine(){
        loggerWrapper.logger.info(END_LINE);
    }

    /**
     * 输出error
     * @param format
     * @param arguments
     */
    public void error(String format, Object... arguments){
        prinErrorStartLine();
        loggerWrapper.logger.error(format,arguments);
        prinErrorEndtLine();
    }

     /**
     * 输出info
     * @param format
     * @param arguments
     */
    public void info(String format, Object... arguments){
        prinInfoStartLine();
        loggerWrapper.logger.info(format,arguments);
        prinInfoEndtLine();
    }

}
