package org.snow.tomcat.demo.utils;

import java.io.UnsupportedEncodingException;

/**
 * date: 2018/9/1 12:44
 * author: snowxuyu
 * describe:
 */
public  abstract class FileNameUtils {

    public static String convertName(String fileName) throws UnsupportedEncodingException {
        return new String(fileName.getBytes("utf-8"),"iso-8859-1");
    }
}
