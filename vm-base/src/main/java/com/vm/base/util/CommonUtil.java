package com.vm.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

/**
 * Title:CommonUtil
 * <p>
 * Description:工具类;
 * <p>
 *
 * @author Kor_Zhang
 * @version 1.0
 * @date 2017年8月31日 下午3:14:15
 */
public class CommonUtil {


    public final static ValidateCode validateCode = new ValidateCode(160, 40, 5, 150);


    public final static <T> List<T> parseStringArray(String stringArray, String splitString) {
        return org.assertj.core.util.Lists.newArrayList(stringArray.split(splitString)).stream().parallel().map(s -> {
            return (T) s;
        }).collect(toList());
    }

    public final static <T> List<T> parseStringArray(String stringArray) {
        String splitString = ",";
        return parseStringArray(stringArray, splitString);
    }

    /**
     * 限速写入,误差10%
     *
     * @param outputStream
     * @param inputStream
     * @param speed        单位b
     * @param startTime
     * @param md5
     * @return
     */
    public final static Long limitedWriter(OutputStream outputStream, InputStream inputStream, Long speed, Long startTime, MessageDigest md5) {
        byte[] b = null;
        b = new byte[1024];
        try {
            OutputStream os = null;
            os = outputStream;
            long count = 0;
            int j;
            while ((j = inputStream.read(b)) != -1) {

                if (count + j > speed) {
                    int need = (int) (speed - count);
                    // 剩下的数
                    int left = (int) (j + count - speed);
                    byte[] temp = new byte[need];
                    byte[] leftTemp = new byte[left];
                    System.arraycopy(b, 0, temp, 0, need);
                    System.arraycopy(b, need, leftTemp, 0, left);
                    os.write(temp);
                    md5.update(temp);
                    os.flush();
                    long endTime = System.currentTimeMillis();
                    long sleepTime = startTime + 1000 - endTime;
                    if (sleepTime > 0) {
                        Thread.sleep(sleepTime);
                    }

                    startTime = System.currentTimeMillis();
                    count = 0;
                    os.write(leftTemp);
                    md5.update(leftTemp);
                    os.flush();
                    count += left;
                    continue;
                }

                if (count + j < speed) {
                    count += j;
                    byte[] temp = new byte[j];
                    System.arraycopy(b, 0, temp, 0, j);
                    os.write(temp);
                    md5.update(b);
                    os.flush();
                    continue;
                }

                if (count + j == speed) {
                    byte[] temp = new byte[j];
                    System.arraycopy(b, 0, temp, 0, j);
                    os.write(temp);
                    md5.update(b);
                    os.flush();
                    long endTime = System.currentTimeMillis();
                    long sleepTime = startTime + 1000 - endTime;
                    if (sleepTime > 0) {
                        Thread.sleep(sleepTime);
                    }
                    // 重置计数器
                    startTime = System.currentTimeMillis();
                    count = 0;
                    continue;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            IOUtil.closeStream(inputStream, null);

        }

        return startTime;

    }


    /**
     * 对象是否为null
     *
     * @param obj
     * @return
     */
    protected final static boolean isNullObject(Object obj) {
        return obj == null;
    }

    /**
     * 集合是否为空
     *
     * @param list
     * @return
     */
    protected final static boolean isEmptyList(List<?> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        for (Object obj : list) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 集合是否为空
     *
     * @param arr
     * @return
     */
    protected final static boolean isEmptyList(Object[] arr) {
        return isEmptyList(Lists.newArrayList(arr));
    }

    /**
     * 集是否空串
     *
     * @param str
     * @return
     */
    protected final static boolean isEmptyString(String str) {
        return str == null || str.trim().length() == 0;
    }


    public static Integer now() {
        return DateUtil.unixTime().intValue();
    }


    public static String uuid() {
        return UUID.randomUUID().toString();
    }


}