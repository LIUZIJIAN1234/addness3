package com.example.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * 文件工具类
 */
@Component
@Slf4j
public class FileUtils {

    private static final String ACCESS_KEY_ID = "LTAI5tFGUB8KAkot1QWJxd4y";

    private static final String ACCESS_KEY_SECRET = "l63cpWcb0P4oyWUj2UhK7ZIKvSXtMz";

    private static final String ENDPOINT = "oss-cn-chengdu.aliyuncs.com";

    private static final String BUCKET_NAME ="dazhiruou-test";

    private static final String OSS_ADDRESS ="https://dazhiruou-test.oss-cn-chengdu.aliyuncs.com/";

    /**
     * 路由斜杠
     */
    private final String backslash = "/";

    /**
     生成UUID的文件名称，用于图片存储
     */
    public static String getThirdId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     获取文件的后缀
     */
    public static String getSuffix(MultipartFile file) {
        // 使用Optional.ofNullable方法将file对象包装成Optional对象
        return Optional.ofNullable(file)
                // 使用map方法取出文件名并过滤掉为空的情况
                .map(MultipartFile::getOriginalFilename)
                // 过滤掉文件名为空的情况
                .filter(fileName -> !fileName.isEmpty())
                // 使用map方法获取后缀名
                .map(fileName -> fileName.substring(fileName.lastIndexOf(".")))
                // 使用orElse方法来处理返回值为null的情况
                .orElse(null);
    }

    /**
     单文件上传
     */
    public String uploadFile(MultipartFile file, String thirdNo, String bucketName) {
        String suffix = FileUtils.getSuffix(file);
        String filePath = thirdNo + suffix;
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            ossClient.putObject(bucketName, filePath, file.getInputStream());
            return filePath;
        } catch (OSSException | ClientException | IOException ossException) {
            throw new RuntimeException();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }


    /**
     上传单个文件
     */
    public String uploadSingleFile(MultipartFile file) {
        String thirdNo = getThirdId();
        String filePath = uploadFile(file, "crudLearning-master/"+ thirdNo, BUCKET_NAME);
        if (StringUtils.isNotEmpty(filePath)) {
            return OSS_ADDRESS + filePath;
        }
        return null;
    }


}
