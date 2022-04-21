package com.pccc.sip.ivrtest.util;

import com.pccc.sip.ivrtest.annotation.ExcelIndex;
import com.pccc.sip.ivrtest.constant.Type;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FileUtil {

    private static final SimpleDateFormat excelFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将单sheet的excel文件转换成对象列表
     * @param file 原文件
     * @param aClass 类
     * @param <T>
     * @return
     */
    public static <T> List<T> excelToObj(MultipartFile file, Class<T> aClass) {
        List<T> list = new ArrayList<>();
        String fileName = file.getOriginalFilename();
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = null;
        Workbook wb = null;
        try {
            is = file.getInputStream();
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet == null) {
                return list;
            }
            Field[] fields = aClass.getDeclaredFields();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                T o = aClass.newInstance();
                for (Field field : fields) {
                    ExcelIndex excelIndex = field.getAnnotation(ExcelIndex.class);
                    if (excelIndex == null) {
                        continue;
                    }
                    field.setAccessible(true);
                    Cell cell = row.getCell(excelIndex.index());
                    if (cell == null) {
                        continue;
                    }
                    String value;
                    if (CellType.NUMERIC == cell.getCellTypeEnum()) {
                        value = String.valueOf((int) cell.getNumericCellValue());
                    } else {
                        value = cell.getStringCellValue();
                    }
                    field.set(o, Type.AttributeType.MAP == excelIndex.type()
                            ? GsonUtil.GsonToBean(value, HashMap.class) : value);
                }
                list.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wb != null) {
                    wb.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     *  将对象列表转成单sheet的excel
     * @param type 文件类型 xls或xlsx,默认xlsx
     * @param title 文件标题
     * @param list 对象列表
     * @param <T>
     * @return
     */
    public static <T> Workbook objToExcel(String type, String[] title, List<T> list) {

        if (StringUtils.isBlank(type)
                || !StringUtils.equalsAny(type, Type.XLSX.getType(), Type.XLS.getType())) {
            type = Type.XLSX.getType();
        }
        Workbook wb = null;
        try {
            if (StringUtils.equals(type, Type.XLSX.getType())) {
                wb = new XSSFWorkbook();
            } else {
                wb = new HSSFWorkbook();
            }
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);

            Sheet sheet = wb.createSheet(excelFormat.format(new Date()));
            Row row = sheet.createRow(0);
            setTitles(title, row, cellStyle);
            setRows(list, sheet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }

    /**
     *  拼接excel文件名称
     * @param type 文件类型 xls或xlsx,默认xlsx
     * @param name 文件名称
     * @param isJointDateTime 文件名是否需要拼接日期
     * @return
     */
    public static String getExcelFileName(String type,String name,boolean isJointDateTime){
        if (StringUtils.isBlank(type)
                || !StringUtils.equalsAny(type, Type.XLSX.getType(), Type.XLS.getType())) {
            type = Type.XLSX.getType();
        }
        String fileName;
        if (StringUtils.isBlank(name)){
            fileName = excelFormat.format(new Date()).concat(".").concat(type);
        }else if (isJointDateTime){
            fileName = name.concat("_").concat(excelFormat.format(new Date())).concat(".").concat(type);
        }else {
            fileName = name.concat(".").concat(type);
        }
        return new String(fileName.getBytes(), StandardCharsets.ISO_8859_1);
    }

    private static void setTitles(String[] title, Row row, CellStyle cellStyle) {
        for (int i = 0; i < title.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(cellStyle);
        }
    }

    private static <T> void setRows(List<T> list, Sheet sheet) throws IllegalAccessException {

        if (list == null){
            return;
        }
        int length = list.size();
        Row row = null;
        for (int i = 0; i < length; i++) {
            row = sheet.createRow(i + 1);
            T entity = list.get(i);
            Class aClass = entity.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                ExcelIndex excelIndex = field.getAnnotation(ExcelIndex.class);
                if (excelIndex == null) {
                    continue;
                }
                int index = excelIndex.index();
                field.setAccessible(true);
                Object obj = field.get(entity);
                if (obj == null){
                    continue;
                }
                String value ;
                if (Type.AttributeType.DATE == excelIndex.type()){
                    value = format.format((Date) obj);
                }else {
                    value = String.valueOf(obj);
                }
                row.createCell(index).setCellValue(value);
            }
        }

    }
}
