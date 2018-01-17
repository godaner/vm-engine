package com.vm.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.assertj.core.util.Lists;
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


    /**
     * 日志打印
     */
    public final static Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 发送邮件工具
     */
    public final static Email email = new Email();

    /**
     * 验证码生成工具
     */
    public final static ValidateCode validateCode = new ValidateCode(160, 40, 5, 150);

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
            closeStream(inputStream, null);

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

    /**
     * Title:
     * <p>
     * Description:写入一个对象到响应流;
     * <p>
     *
     * @param o
     * @param response
     * @author Kor_Zhang
     * @date 2017年9月29日 下午7:15:44
     * @version 1.0
     */
    public static void writeJSON(Object o, HttpServletResponse response) {
        if (null == o) {
            return;
        }
        PrintWriter pt = null;
        try {
            // 获取输出流
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            pt = response.getWriter();
            // 序列化对象
            String json = JSON.toJSONStringWithDateFormat(o,
                    "yyyy-MM-dd HH:mm:ss",
                    SerializerFeature.DisableCircularReferenceDetect);
            // 写入对象
            pt.write(json);
            pt.flush();
            pt.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            pt.close();
        }
    }

    /**
     * Title:
     * <p>
     * Description:删除多个版本的文件;
     * <p>
     *
     * @param path
     * @param fileName
     * @param versions
     * @author Kor_Zhang
     * @date 2017年9月28日 上午11:16:39
     * @version 1.0
     */
    public static void deleteVersionsFile(String path, String fileName, String versions) {
        String[] widthStrs = versions.split(",");

        for (String widthStr : widthStrs) {

            File targetFile = new File(path + widthStr + "_" + fileName);

            deleteFile(targetFile);
        }
    }


    /**
     * Title:timestamp
     * <p>
     * Description:返回当前时间的Timestamp
     * <p>
     *
     * @return
     * @author Kor_Zhang
     * @date 2017年9月21日 下午10:46:06
     * @version 1.0
     */
    public static Timestamp timestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Title:compressImg
     * <p>
     * Description:按比例缩放图片;
     * <p>
     *
     * @param source 待压缩图片;
     * @param scale  缩放比例:double类型;宽高同时缩放;1.0代表原比例;
     * @author Kor_Zhang
     * @date 2017年9月20日 下午1:54:30
     * @version 1.0
     */
    public void compressImg(File source, File target, Double scale) {
        try {
            Thumbnails.of(source).scale(scale).toFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Title:compressImg
     * <p>
     * Description:压缩图片;遵循原图宽高比例
     * <p>
     *
     * @param source 待压缩图片;
     * @param target 压缩后的图片;
     * @param width  压缩后的宽;
     * @author Kor_Zhang
     * @date 2017年9月20日 下午2:00:17
     * @version 1.0
     */
    public void compressImg(File source, File target, Integer width) {
        try {
            Thumbnails.of(source).width(width).keepAspectRatio(true)
                    .toFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Title:uuid
     * <p>
     * Description:返回一个不重复的uuid字符串;
     * <p>
     *
     * @return
     * @author Kor_Zhang
     * @date 2017年9月13日 下午10:34:27
     * @version 1.0
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * Title:writeFileToOS
     * <p>
     * Description:将文件写入输出流
     * <p>
     *
     * @param os
     * @author Kor_Zhang
     * @date 2017年9月20日 上午10:29:56
     * @version 1.0
     */
    public static void writeFileToOS(String filePath, OutputStream os) {

        writeFileToOS(new File(filePath), os);

    }

    /**
     * Title:writeFileToOS
     * <p>
     * Description:将文件写入输出流
     * <p>
     *
     * @param os
     * @author Kor_Zhang
     * @date 2017年9月20日 上午10:29:56
     * @version 1.0
     */
    public static void writeFileToOS(File file, OutputStream os) {

        FileInputStream in = null;

        byte[] bytes = new byte[1024];

        int len = 0;

        try {

            in = new FileInputStream(file);

            while ((len = in.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(in, os);
        }

    }

    /**
     * Title:multipartFile2File
     * <p>
     * Description:获取multipartFile2File中的file
     * <p>
     *
     * @param file
     * @return
     * @author Kor_Zhang
     * @date 2017年9月20日 下午2:58:59
     * @version 1.0
     */
    public File multipartFile2File(MultipartFile file) {
        CommonsMultipartFile cf = (CommonsMultipartFile) file; // 这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        return fi.getStoreLocation();
    }

    /**
     * Title:
     * <p>
     * Description:将原图片压缩成多个版本的压缩图片,保存到指定目录;<br/>
     * 宽高比在压缩的过程中不变;<br/>
     * 如果源文件名为:a.png,压缩后根据版本会产生名为40_a.png,80_a.png,200_a.png的多个文件;
     * <p>
     *
     * @param sourceFile 待压缩文件;
     * @param versions   压缩版本:40,80,200;宽分别为40,80,200的图片;宽高比不变;
     * @param savePath   文件保存路径,如:d:\floder\
     * @param fileName   文件名,如:a.jpg
     * @author Kor_Zhang
     * @date 2017年9月20日 下午2:28:11
     * @version 1.0
     */
    public void writeFileWithCompress(File sourceFile, String versions,
                                      String savePath, String fileName) {
        String[] widthStrs = versions.split(",");

        for (String widthStr : widthStrs) {
            Integer width = Integer.valueOf(widthStr);

            File targetFile = new File(savePath + File.separator + widthStr + "_" + fileName);

            compressImg(sourceFile, targetFile, width);
        }

    }

    /**
     * 写入文件到本地磁盘
     *
     * @param sourceFile
     * @param targetFile
     */
    public void writeFileToDisk(File sourceFile, File targetFile) {
        try {
            // 获取文件流
            FileOutputStream fos = new FileOutputStream(targetFile);
            // 获取数据
            byte[] data = IOUtils.toByteArray(new FileInputStream(sourceFile));
            // 写入
            IOUtils.write(data, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入文件到本地磁盘
     *
     * @param sourceFile
     * @param filePath
     * @param fileName
     * @return
     */
    public File writeFileToDisk(File sourceFile, String filePath,
                                String fileName) {
        File targetFile = null;
        try {
            // 获取文件流
            targetFile = new File(filePath, fileName);

            // 写入操作
            writeFileToDisk(sourceFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetFile;
    }

    /**
     * 字符串转化为Timestamp
     *
     * @param dateStr
     * @return
     */
    public static Timestamp stringToTimestamp(String dateStr) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            Date date = sdf.parse(dateStr);
            date.getTime();
            cal.setTime(date);
            return new Timestamp(cal.getTimeInMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }

        cal.setTime(new Date());
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * 获取文件名的后缀
     *
     * @param fileName ：文件名，如d:\zhangke\javaee作业.zip或javaee作业.zip
     * @return
     * @throws Exception
     */
    public static String getFileNameExt(String fileName) {

        if (fileName == null || fileName.equals("")) {
            return "";
        }
        if (fileName.indexOf(".") < 0) {
            return "";
        }

        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 取得文件大小
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            return fis.available();
        }
        return 0;
    }

    /**
     * copy文件内容
     *
     * @param src ：源文件
     * @param dst ：目标文件
     */
    public static void copyFiles(File src, File dst) {
        final int BUFFER_SIZE = 2 * 1024;
        InputStream in = null;
        OutputStream out = null;
        try {
            if (dst.exists()) {
                out = new BufferedOutputStream(new FileOutputStream(dst, true),
                        BUFFER_SIZE);
            } else {
                out = new BufferedOutputStream(new FileOutputStream(dst),
                        BUFFER_SIZE);
            }
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(in, out);
        }
    }

    /**
     * 删除指定文件
     *
     * @param file
     * @return
     */
    public static Boolean deleteFile(File file) {
        try {
            if (file != null && file.exists()) {
                file.delete();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 批量删除files
     *
     * @param filePaths
     * @return
     */
    public static Boolean deleteFiles(String... filePaths) {

        Lists.newArrayList(filePaths).stream().parallel().forEach((filePath) -> {
            deleteFile(new File(filePath));
        });
        return true;
    }

    /**
     * 批量删除files
     *
     * @param files
     * @return
     */
    public static Boolean deleteFiles(File... files) {

        Lists.newArrayList(files).stream().parallel().forEach((file) -> {
            deleteFile(file);
        });
        return true;
    }

    /**
     * 加载properties
     *
     * @param propsPath ：propsPath开头不加斜杠
     * @return
     * @throws Exception
     */
    public static Properties loadProps(String propsPath) {

        // 申明初始化properties
        Properties props = new Properties();
        // 获取类路径下的properties文件
        InputStream inStream = CommonUtil.class.getClassLoader().getResourceAsStream(
                propsPath);
        try {
            props.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭流
        CommonUtil.closeStream(inStream, null);
        // 返回参数
        return props;
    }

    /**
     * Title:loadProps
     * <p>
     * Description:加载指定路径的属性文件,最后合并到指定的属性对象,不覆盖原来属性;
     * <p>
     *
     * @param to       被新增的属性对象
     * @param fromPath 新增的属性文件的地址
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:29:29
     * @version 1.0
     */
    public static Properties loadProps(Properties to, String fromPath) {

        // 获取类路径下的properties文件
        InputStream inStream = CommonUtil.class.getClassLoader().getResourceAsStream(
                fromPath);
        try {
            to.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭流
        CommonUtil.closeStream(inStream, null);
        // 返回参数
        return to;
    }

    /**
     * Title:loadProps
     * <p>
     * Description:加载指定路径的属性文件,最后合并到指定的属性对象,不覆盖原来属性;
     * <p>
     *
     * @param to   被新增的属性对象
     * @param from 新增的属性文件
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:29:29
     * @version 1.0
     */
    public static Properties loadProps(Properties to, File from) {

        // 获取类路径下的properties文件
        InputStream inStream = null;
        try {
            inStream = new FileInputStream(from);
            to.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭流
        CommonUtil.closeStream(inStream, null);
        // 返回参数
        return to;
    }

    /**
     * Title:loadDirProps
     * <p>
     * Description:加载类路径下指定目录的properties文件到一个properties对象中; 获取根路径的文件传入"";
     * <p>
     *
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午9:52:32
     * @version 1.0
     */
    public static Properties loadClassPathProps(String classPath,
                                                String fileNameRegex) {

        Properties props = new Properties();

        // 获取类路径下的指定目录的文件
        List<File> childs = CommonUtil.classPathChilds(classPath, fileNameRegex);

        // 加载所有的属性文件到一个属性对象中
        for (File file : childs) {
            CommonUtil.loadProps(props, file);
        }

        return props;
    }

    /**
     * Title:classPathChilds
     * <p>
     * Description:获取类路径的指定目录的所有文件;开头不需"/";<br/>
     * 例如:想要获取根目录的所有文件,只需要传入"";
     * <p>
     *
     * @param classPath     指定加载的文件的路径
     * @param fileNameRegex 文件名过滤器,满足的会被返回
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:44:03
     * @version 1.0
     */
    public static List<File> classPathChilds(String classPath,
                                             String fileNameRegex) {

        List<File> childs = getList();

        String destPath = CommonUtil.class.getResource("/").getPath() + classPath;

        childs = dirChilds(destPath, fileNameRegex);

        return childs;
    }

    /**
     * Title:classPathChilds
     * <p>
     * Description:获取类路径的指定目录的所有文件;开头不需"/";<br/>
     * 例如:想要获取根目录的所有文件,只需要传入"";
     * <p>
     *
     * @param classPath 指定加载的文件的路径
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:44:03
     * @version 1.0
     */
    public static List<File> classPathChilds(String classPath) {

        return classPathChilds(classPath, null);
    }

    /**
     * Title:dirChilds
     * <p>
     * Description:获取指定目录的子文件;
     * <p>
     *
     * @param dirPath 指定加载的文件的路径
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:45:09
     * @version 1.0
     */
    public static List<File> dirChilds(String dirPath) {

        return dirChilds(dirPath);
    }

    /**
     * Title:dirChilds
     * <p>
     * Description:获取指定目录的子文件;
     * <p>
     *
     * @param dirPath       指定加载的文件的路径
     * @param fileNameRegex 文件名过滤器,满足的会被返回
     * @return
     * @author Kor_Zhang
     * @date 2017年9月14日 上午8:45:09
     * @version 1.0
     */
    public static List<File> dirChilds(String dirPath, String fileNameRegex) {
        List<File> childs = getList();

        File dir = new File(dirPath);

        File[] files = dir.listFiles();
        // 不过滤文件名
        if (null == fileNameRegex || fileNameRegex.trim().isEmpty()) {

            for (File file : files) {
                if (file.isFile()) {
                    childs.add(file);
                }
            }
            return childs;
        }
        // 过滤文件名
        for (File file : files) {
            if (file.isFile() && file.getName().matches(fileNameRegex)) {
                childs.add(file);
            }
        }

        return childs;
    }

    /**
     * 关闭流
     *
     * @param in
     * @param out
     */
    public static void closeStream(InputStream in, OutputStream out) {
        /**
         * 1.判断流是否为null 2.执行操作
         */
        // 1.判断流是否为null
        if (in != null) {
            // 2.执行操作
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 1.判断流是否为null
        if (out != null) {
            // 2.执行操作
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据Long型的生日获取年龄
     *
     * @param birthdayTime
     * @return
     */
    public static int getAgeByYears(Long birthdayTime) {
        Integer age = new Date().getYear() - new Date(birthdayTime).getYear();
        if (age <= 0) {
            age = -1;
        }
        return age;
    }

    /**
     * 更具Integer型的生日获取年龄
     *
     * @param birthdayTime
     * @return
     */
    public static int getAgeByYears(Integer birthdayTime) {
        Integer age = new Date().getYear() - new Date(birthdayTime).getYear();
        if (age <= 0) {
            age = -1;
        }
        return age;
    }

    /**
     * 验证正则
     *
     * @param data ：待验证数据
     * @param reg  ：正则表达式
     * @return
     */
    public static Boolean check(String data, String reg) {
        Pattern regex = Pattern.compile(reg);
        Matcher matcher = regex.matcher(data);
        return matcher.matches();
    }

    /**
     * 复制一个list中的元素到另一个list
     *
     * @param targetClazz
     * @param sourceList
     * @param <T>
     * @return
     */
    public static <T> List<T> copyProList(Class<T> targetClazz,
                                          List<?> sourceList) {
        // 验证待复制的list有效性
        if (null == sourceList) {
            return null;
        }
        List<T> newList = getList();
        if (sourceList.size() == 0) {
            return newList;
        }
        // 遍历复制list中对象属性
        int index = 0;
        while (index < sourceList.size()) {
            Object obj = null;
            try {
                obj = targetClazz.newInstance();
                BeanUtils.copyProperties(sourceList.get(index), obj);
            } catch (Exception e) {
                e.printStackTrace();
            }

            newList.add((T) obj);
            index++;
        }
        return newList;
    }

    /**
     * 快速获取一个ArrayList实例
     *
     * @return
     */
    public static <T> List<T> getList() {
        return new ArrayList<T>();
    }

    /**
     * 快速获取一个HashMap实例
     *
     * @return
     */
    public static <K, V> Map<K, V> getMap() {
        return new HashMap<K, V>();
    }

    /**
     * 快速获取一个HashMap实例，并且填入参数
     *
     * @return
     */
    public static <K, V> Map<K, V> getMap(K[] keys, V[] vals) {
        Map<K, V> map = getMap();
        if (null == keys || null == vals || 0 == keys.length
                || 0 == vals.length || keys.length != vals.length) {
            return map;
        }
        int i = 0;
        while (i < keys.length) {
            map.put(keys[i], vals[i]);
            i++;
        }
        return map;
    }

    /**
     * 二次加密，应该破解不了了吧？
     *
     * @param inputText
     * @return
     */
    public static String md5AndSha(String inputText) {
        return sha(md5(inputText));
    }

    /**
     * md5加密
     *
     * @param inputText
     * @return
     */
    public static String md5(String inputText) {
        return encrypt(inputText, "md5");
    }

    /**
     * sha加密
     *
     * @param inputText
     * @return
     */
    public static String sha(String inputText) {
        return encrypt(inputText, "sha-1");
    }

    /**
     * md5或者sha-1加密
     *
     * @param inputText     要加密的内容
     * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
     * @return
     */
    private static String encrypt(String inputText, String algorithmName) {
        if (inputText == null || "".equals(inputText.trim())) {
            throw new IllegalArgumentException("请输入要加密的内容");
        }
        if (algorithmName == null || "".equals(algorithmName.trim())) {
            algorithmName = "md5";
        }
        String encryptText = null;
        try {
            MessageDigest m = MessageDigest.getInstance(algorithmName);
            m.update(inputText.getBytes("UTF8"));
            byte s[] = m.digest();
            // m.digest(inputText.getBytes("UTF8"));
            return hex(s);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encryptText;
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr
     * @return
     */
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,
                    3));
        }
        return sb.toString();
    }

}