package com.pccc.sip.ivrtest.controller;


import com.pccc.sip.ivrtest.entity.request.QueryECResPageRequest;
import com.pccc.sip.ivrtest.entity.response.QueryECResPageResponse;
import com.pccc.sip.ivrtest.service.ExecuteCaseResultService;
import com.pccc.sip.ivrtest.util.ExcelInformationUtil;
import com.pccc.sip.ivrtest.util.FileUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/executeCaseResult")
public class ExecuteCaseResultController {

    @Autowired
    private ExecuteCaseResultService executeCaseResultService;

    @PostMapping("/query")
    public QueryECResPageResponse queryExecuteCaseByPage(@RequestBody QueryECResPageRequest request){
        return executeCaseResultService.queryByPage(request);
    }

    @GetMapping("/exportResult")
    public void exportExcel(@RequestParam(value = "id") String id,
                            @RequestParam(value = "type",required = false) String type, HttpServletResponse response){
        OutputStream outputStream = null;
        Workbook workbook = null;
        try {
            String fileName = FileUtil.getExcelFileName(type, ExcelInformationUtil.getString("execCaseResultExport","name"),true);
            response.addHeader("Content-Disposition", "filename=" + fileName);
            outputStream = response.getOutputStream();
            workbook = FileUtil.objToExcel(type,ExcelInformationUtil.getStringArray("execCaseResultExport","title"),executeCaseResultService.queryAllList(id));
            workbook.write(outputStream);
            outputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null){
                    outputStream.close();
                }
                if (workbook!=null){
                    workbook.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
