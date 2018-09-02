package org.snow.tomcat.demo.controller;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snow.tomcat.demo.utils.FileNameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * date: 2018/9/2 14:34
 * author: snowxuyu
 * describe:
 */

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.info(">>>>>>> 开始导出Excel");

        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=" + FileNameUtils.convertName("测试Excel") + ".xlsx");
        response.setContentType("application/msexcel");

        //创建一个Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();

        //创建sheet页
        Sheet sheet = workbook.createSheet("征信查询");

        sheet.setDefaultColumnWidth((short) 20);

        mergeCells(sheet);

        CellStyle titleStyle = createTitleStyle(workbook);
        CellStyle cellStyle = workbook.createCellStyle();

        //创建标题行
        Row row1 = sheet.createRow(0);

        createTitleCell(row1, 0, "商户名称", titleStyle);
        createTitleCell(row1, 1, "变更信息", titleStyle);
        createTitleCell(row1, 5, "动产抵押-变更信息", titleStyle);
        createTitleCell(row1, 8, "股权处置-变更信息", titleStyle);

        Row row2 = sheet.createRow(1);
        String titleStr = "变更事项|变更前内容|变更后内容|变更时间|变更内容|登记编号|变更日期|变更内容|关联内容|变更日期";
        List<String> titleList = Arrays.asList(titleStr.split("\\|"));
        for (int i = 0; i < titleList.size(); i++) {
            createTitleCell(row2, i+1, titleList.get(i), titleStyle);
        }
        workbook.write(outputStream);
        outputStream.close();


    }

    /**
     * 合并单元格
     * @param sheet
     */
    private void mergeCells(Sheet sheet) {
        CellRangeAddress cellRangeAddress1 = new CellRangeAddress(0, 0, 1, 4);
        sheet.addMergedRegion(cellRangeAddress1);

        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(0, 0, 5, 7);
        sheet.addMergedRegion(cellRangeAddress2);

        CellRangeAddress cellRangeAddress3 = new CellRangeAddress(0, 0, 8, 10);
        sheet.addMergedRegion(cellRangeAddress3);

        CellRangeAddress cellRangeAddress4 = new CellRangeAddress(0, 1, 0, 0);
        sheet.addMergedRegion(cellRangeAddress4);
        setBorderStyle(BorderStyle.THIN, cellRangeAddress1, sheet);
        setBorderStyle(BorderStyle.THIN, cellRangeAddress2, sheet);
        setBorderStyle(BorderStyle.THIN, cellRangeAddress3, sheet);
        setBorderStyle(BorderStyle.THIN, cellRangeAddress4, sheet);
    }


    /**  创建标题单元格
     * @param row        行号
     * @param index      索引
     * @param cellValue  值
     * @param titleStyle 格式
     */
    private void createTitleCell(Row row, int index, String cellValue, CellStyle titleStyle) {
        Cell cell = row.createCell(index);
        cell.setCellStyle(titleStyle);
        cell.setCellValue(cellValue);
    }

    /**
     * 创建标题单元格格式
     * @param workbook
     * @return
     */
    private CellStyle createTitleStyle(Workbook workbook) {
        // 创建样式对象
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFillForegroundColor(HSSFColor.GOLD.index);
        titleStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        titleStyle.setBorderBottom(BorderStyle.THIN); //下边框
        titleStyle.setBorderLeft(BorderStyle.THIN);//左边框
        titleStyle.setBorderTop(BorderStyle.THIN);//上边框
        titleStyle.setBorderRight(BorderStyle.THIN);//右边框
        // 设置字体
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setColor(HSSFColor.VIOLET.index);
        titleStyle.setFont(titleFont);
        return titleStyle;
    }

    private void setBorderStyle(BorderStyle border, CellRangeAddress region, Sheet sheet) {
        RegionUtil.setBorderBottom(border, region, sheet);
        RegionUtil.setBorderLeft(border, region, sheet);
        RegionUtil.setBorderRight(border, region, sheet);
        RegionUtil.setBorderTop(border, region, sheet);
    }
}
