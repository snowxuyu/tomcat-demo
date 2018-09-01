package org.snow.tomcat.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * date: 2018/9/1 17:58
 * author: snowxuyu
 * describe:
 */
public interface PdfService {

    ByteArrayOutputStream convertPdf(String companyName) throws IOException;
}

