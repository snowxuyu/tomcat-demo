package org.snow.tomcat.demo.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snow.tomcat.demo.service.PdfService;
import org.snow.tomcat.demo.utils.FileNameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * date: 2018/9/1 11:59
 * author: snowxuyu
 * describe:
 */
@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PdfService pdfService;

    /**
     * 导出PDF文件
     *
     * @param request
     * @param response
     */
    @RequestMapping("/exportPdf")
    public void exportPdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info(">>>>>>> 开始导出pdf文件");

        ByteArrayOutputStream baos = pdfService.convertPdf("1111");

        response.setContentType("application/vnd.ms-pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + FileNameUtils.convertName("测试导出") + ".pdf");
        response.setContentLength(baos.size());
        OutputStream out = response.getOutputStream();
        baos.writeTo(out);
        IOUtils.closeQuietly(baos);
        IOUtils.closeQuietly(out);
    }


}
