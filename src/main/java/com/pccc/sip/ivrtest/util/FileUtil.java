package com.pccc.sip.ivrtest.util;

import com.pccc.sip.ivrtest.annotation.ExcelIndex;
import com.pccc.sip.ivrtest.constant.Type;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUtil {

    public static <T> List<T> excelToObj(MultipartFile file,Class<T> aClass){
        List<T> list = new ArrayList<>();
        String fileName = file.getOriginalFilename();
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = null;
        Workbook wb = null;
        try{
            is = file.getInputStream();
            if (isExcel2003) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = wb.getSheetAt(0);
            if (sheet == null){
                return list;
            }
            Field[] fields = aClass.getDeclaredFields();
            for (int i =1 ;i <= sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                T o = aClass.newInstance();
                for (Field field:fields){
                    ExcelIndex excelIndex = field.getAnnotation(ExcelIndex.class);
                    if (excelIndex == null){
                        continue;
                    }
                    field.setAccessible(true);
                    Cell cell = row.getCell(excelIndex.index());
                    if (cell == null){
                        continue;
                    }
                    String value;
                    if (CellType.NUMERIC == cell.getCellTypeEnum()){
                        value = String.valueOf((int)cell.getNumericCellValue());
                    }else {
                        value = cell.getStringCellValue();
                    }
                    field.set(o,excelIndex.type() == Type.AttributeType.MAP
                            ? GsonUtil.GsonToBean(value, HashMap.class):value);
                }
                list.add(o);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (wb!=null){
                    wb.close();
                }
                if (is!=null){
                    is.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
