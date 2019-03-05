package com.gupao.learn.design.model.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Description:数据流相关工具类
 *
 * @author 轩辚
 * @date 2019/3/5 22:25
 */
public class StreamUtil {
    /**
     * 初始化日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(StreamUtil.class);


    /**
     * 关闭输入流
     */
    public static void closeInputStream(InputStream inputStream){
        try {
            if (null != inputStream) {
                inputStream.close();
            }
        }catch (IOException e){
            logger.info("关闭输入流异常",e);
        }
    }

    /**
     * 关闭输出流
     */
    public static void closeOutputStream(OutputStream outputStream){
        try {
            if (null != outputStream) {
                outputStream.close();
            }
        }catch (IOException e){
            logger.info("关闭输出流异常",e);
        }
    }
}
