package com.vm.base.util;

import com.google.common.collect.Lists;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * Created by ZhangKe on 2018/3/15.
 */
public class IOUtil {
    /**
     * 关闭流
     *
     * @param in
     * @param out
     */
    public final static void closeStream(InputStream in, OutputStream out) {
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
    public final static void mkdirs(String filePathName) {
        new File(filePathName).mkdirs();
    }

    public final static void deleteFile(File file) throws Exception {

        try {
            if (file == null) {
                throw new Exception("file is null ! ");
            }
            if (!file.exists()) {
                throw new Exception("file is not exits ! ");
            }
            file.delete();
        } catch (Exception e) {
            throw e;
        }
    }

    public final static void deleteFiles(String... filePathNames) {

        Lists.newArrayList(filePathNames).stream().parallel().forEach((filePathName) -> {
            try {
                IOUtil.deleteFile(new File(filePathName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public final static void deleteFiles(File... files) {

        Lists.newArrayList(files).stream().parallel().forEach((file) -> {
            try {
                IOUtil.deleteFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
     * 写入文件到本地磁盘
     *
     * @param sourceFile
     * @param targetFile
     */
    public final void writeFileToDisk(File sourceFile, File targetFile) {
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
    public final File writeFileToDisk(File sourceFile, String filePath,
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
     * 获取文件名的后缀
     *
     * @param fileName ：文件名，如d:\zhangke\javaee作业.zip或javaee作业.zip
     * @return
     * @throws Exception
     */
    public final static String getFileNameExt(String fileName) {

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
    public final static long getFileSize(File file) throws Exception {
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
    public final static void copyFiles(File src, File dst) {
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

}
