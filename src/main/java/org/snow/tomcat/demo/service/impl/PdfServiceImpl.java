package org.snow.tomcat.demo.service.impl;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snow.tomcat.demo.controller.PdfController;
import org.snow.tomcat.demo.service.PdfService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * date: 2018/9/1 17:58
 * author: snowxuyu
 * describe:
 */

@Service
public class PdfServiceImpl implements PdfService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ByteArrayOutputStream convertPdf(String companyName) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //创建一个编写PDF文件的对象
        PdfWriter writer = new PdfWriter(baos);
        //PdfDocument是管理添加的内容
        PdfDocument pdf = new PdfDocument(writer);
        //创建一个文档对象,并设置大小是A4
        Document document = new Document(pdf, PageSize.A4.rotate());

        PdfFont font = getPdfFont();

        setTitle(document, "企业征信查询报告书", font);

        addEmptyParagraph(document);

        //企业基本信息
        setHeader(document, "企业基本信息", font);
        Table baseInfoTable = createTable(4, font);


        addTableHeaderCell(baseInfoTable, "统一信用代码", font);
        addTableCell(baseInfoTable, "91310109090056955F", font);

        addTableHeaderCell(baseInfoTable, "邮箱", font);
        addTableCell(baseInfoTable, "test@test.com", font);

        addTableHeaderCell(baseInfoTable, "组织机构代码", font);
        addTableCell(baseInfoTable, "090056955", font);

        addTableHeaderCell(baseInfoTable, "注册资本（万元）", font);
        addTableCell(baseInfoTable, "6000.000000", font);

        addTableHeaderCell(baseInfoTable, "国民经济行业代码", font);
        addTableCell(baseInfoTable, "653", font);

        addTableHeaderCell(baseInfoTable, "实收资本(万元)", font);
        addTableCell(baseInfoTable, "50.000000", font);

        addTableHeaderCell(baseInfoTable, "国民经济代码名称", font);
        addTableCell(baseInfoTable, "信息技术咨询服务", font);

        addTableHeaderCell(baseInfoTable, "注册资本币种", font);
        addTableCell(baseInfoTable, "人民币元", font);

        addTableHeaderCell(baseInfoTable, "企业名称", font);
        addTableCell(baseInfoTable, "上海前隆信息科技有限公司", font);

        addTableHeaderCell(baseInfoTable, "原注册号", font);
        addTableCell(baseInfoTable, "-", font);

        addTableHeaderCell(baseInfoTable, "企业英文名称", font);
        addTableCell(baseInfoTable, "上海前隆信息科技有限公司", font);

        addTableHeaderCell(baseInfoTable, "企业英文名称", font);
        addTableCell(baseInfoTable, "上海前隆信息科技有限公司", font);

        addTableHeaderCell(baseInfoTable, "注册号", font);
        addTableCell(baseInfoTable, "310109000645413", font);

        addTableHeaderCell(baseInfoTable, "曾用名", font);
        addTableCell(baseInfoTable, "上海前隆金融信息服务有限公司", font);

        addTableHeaderCell(baseInfoTable, "登记机关", font);
        addTableCell(baseInfoTable, "虹口区市场监管局", font);

        addTableHeaderCell(baseInfoTable, "成立日期", font);
        addTableCell(baseInfoTable, "2014-01-10", font);

        addTableHeaderCell(baseInfoTable, "所在城市", font);
        addTableCell(baseInfoTable, "上海市", font);

        addTableHeaderCell(baseInfoTable, "法定代表人/负责人/执行事务合伙人", font);
        addTableCell(baseInfoTable, "俞亮", font);

        addTableHeaderCell(baseInfoTable, "所在区县", font);
        addTableCell(baseInfoTable, "上海市虹口区", font);

        addTableHeaderCell(baseInfoTable, "经营状态", font);
        addTableCell(baseInfoTable, "在营（开业）", font);

        addTableHeaderCell(baseInfoTable, "注册地址行政编号", font);
        addTableCell(baseInfoTable, "310109", font);

        addTableHeaderCell(baseInfoTable, "经营期限自", font);
        addTableCell(baseInfoTable, "2014-01-10", font);

        addTableHeaderCell(baseInfoTable, "组织机构代码行政区划", font);
        addTableCell(baseInfoTable, "上海市", font);

        addTableHeaderCell(baseInfoTable, "经营期限至", font);
        addTableCell(baseInfoTable, "2034-01-09", font);

        addTableHeaderCell(baseInfoTable, "吊销日期", font);
        addTableCell(baseInfoTable, "-", font);

        addTableHeaderCell(baseInfoTable, "企业类型", font);
        addTableCell(baseInfoTable, "有限责任公司(自然人投资或控股)", font);

        addTableHeaderCell(baseInfoTable, "核准日期", font);
        addTableCell(baseInfoTable, "2014-01-10", font);

        addTableHeaderCell(baseInfoTable, "住址", font);
        addTableCell(baseInfoTable, "上海市虹口区东大名路1050号901-908室", font);

        addTableHeaderCell(baseInfoTable, "注销日期", font);
        addTableCell(baseInfoTable, "-", font);

        addTableHeaderCell(baseInfoTable, "住所所在行政区划", font);
        addTableCell(baseInfoTable, "310109", font);

        addTableHeaderCell(baseInfoTable, "许可经营项目", font);
        addTableCell(baseInfoTable, "接受金融机构委托从事金融信息技术外包，接受金融机构委托从事金融业务流程外包，接受金融机构委托从事金融知识流程外包，网络信息科技领域内的技术开发、技术转让、技术咨询、技术服务，实业投资，市场营销策划，企业管理，会展会务服务，市场信息咨询与调查（不得从事社会调查、社会调研、民意调查、民意测验），商务咨询，销售日用百货。【依法须经批准的项目，经相关部门批准后方可开展经营活动】", font);

        addTableHeaderCell(baseInfoTable, "经营业务范围", font);
        addTableCell(baseInfoTable, "网络信息科技领域内的技术开发、技术转让、技术咨询、技术服务，接受金融机构委托从事金融信息技术外包，接受金融机构委托从事金融业务流程外包，接受金融机构委托从事金融知识流程外包，实业投资，市场营销策划，企业管理，会展会务服务，市场信息咨询与调查（不得从事社会调查、社会调研、民意调查、民意测验），商务咨询，销售日用百货。 【依法须经批准的项目，经相关部门批准后方可开展经营活动】", font);

        document.add(baseInfoTable);

        addEmptyParagraph(document);

        //变更信息
        setHeader(document, "变更信息", font);
        Table alertTable = createTable(4, font);
        addTableHeaderCell(alertTable, "变更事项|变更前内容|变更后内容|变更日期", font);
        for (int i = 0; i < 9; i++) {
            addTableCell(alertTable, "测试数据" + i, font);
        }
        document.add(alertTable);


        document.close();
        writer.close();

        return baos;
    }


    //添加空段落
    private void addEmptyParagraph(Document document) {
        document.add(new Paragraph(""));
    }


    //生成Table表格
    private Table createTable(int numColumns, PdfFont font) {
        Table table = new Table(numColumns);
        table.setWidth(UnitValue.createPercentValue(90));
        //设置高度18毫米，设置边框固定  字体兼容中文  表格居中
        table.setMinHeight(18).setFixedLayout().setFont(font).setHorizontalAlignment(HorizontalAlignment.CENTER);
        return table;
    }

    //添加单元格内容
    private void addTableCell(Table table, String content, PdfFont font) {
        table.addCell(new Cell().add(new Paragraph(content).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER).setFont(font).setFontSize(10)));
    }

    //添加表格标题单元格
    private void addTableHeaderCell(Table table, String content, PdfFont font) {
        List<String> titleList = Arrays.asList(content.split("\\|"));
        titleList.forEach(title -> {
            table.addCell(new Cell().add(new Paragraph(title).setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER).setFont(font).setFontSize(10).setBold()));
        });

    }

    //设置表格的小标题
    private void setHeader(Document document, String header, PdfFont font) {
        Paragraph paragraphHeader = new Paragraph(header);
        paragraphHeader.setFont(font).setFontSize(12).setBold();
        document.add(paragraphHeader);
    }

    //Pdf 大标题居中加粗
    private void setTitle(Document document, String title, PdfFont font) {
        Paragraph paragraphTitle = new Paragraph(title);
        paragraphTitle.setTextAlignment(TextAlignment.CENTER).setHorizontalAlignment(HorizontalAlignment.CENTER);
        paragraphTitle.setFont(font).setFontSize(30).setBold();
        document.add(paragraphTitle);
    }

    //设置pdf 显示中文 宋体
    private PdfFont getPdfFont() throws IOException {
        InputStream inputStream = PdfController.class.getClassLoader().getResourceAsStream("raw/simsun.ttf");
        return PdfFontFactory.createFont(IOUtils.toByteArray(inputStream), PdfEncodings.IDENTITY_H, false);
    }

}
