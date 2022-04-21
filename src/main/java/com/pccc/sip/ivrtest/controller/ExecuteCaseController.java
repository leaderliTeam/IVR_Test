package com.pccc.sip.ivrtest.controller;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.engine.EngineRedisQueue;
import com.pccc.sip.ivrtest.entity.*;
import com.pccc.sip.ivrtest.entity.request.DeleteExecCaseRequest;
import com.pccc.sip.ivrtest.entity.request.FillDataRequest;
import com.pccc.sip.ivrtest.entity.request.QueryExecCasePageRequest;
import com.pccc.sip.ivrtest.entity.response.BaseResponse;
import com.pccc.sip.ivrtest.entity.response.ExecuteCaseResponse;
import com.pccc.sip.ivrtest.entity.response.QueryExecCasePageResponse;
import com.pccc.sip.ivrtest.service.CommonService;
import com.pccc.sip.ivrtest.service.ExecuteCaseService;
import com.pccc.sip.ivrtest.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/executeCase")
public class ExecuteCaseController {

    @Autowired
    private EngineRedisQueue engineRedisQueue;
    @Autowired
    private ExecuteCaseService executeCaseService;
    @Autowired
    private CommonService commonService;

    @PostMapping("/execute")
    public ExecuteCaseResponse executeCases(@RequestBody List<ExecuteCaseEntity> executeCaseEntities){
        int size = engineRedisQueue.put(executeCaseEntities);
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        executeCaseResponse.setSize(size);
        return executeCaseResponse;
    }

    @PostMapping("/addData")
    public BaseResponse addData(@RequestBody FillDataRequest fillDataRequest){
        boolean flag = executeCaseService.addBatchExecCase(fillDataRequest);
        BaseResponse baseResponse = new BaseResponse();
        if (!flag){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @GetMapping("/queryId")
    public ExecuteCaseResponse queryCaseId(@RequestParam(value = "queryType") String queryType){
        ExecuteCaseResponse executeCaseResponse = new ExecuteCaseResponse();
        if (!StringUtils.equalsAny(queryType,Type.EXECCASE.getType(),Type.TESTCASE.getType())){
            executeCaseResponse.setReturnMsg(Type.FAIL);
            executeCaseResponse.setMsg("查询类型有误，请检查");
        }else {
            String id = commonService.getTodayCaseIdOfNew(queryType);
            executeCaseResponse.setId(id);
        }
        return executeCaseResponse;
    }

    @PostMapping("/add")
    public BaseResponse addExecuteCase(@RequestBody ExecuteCaseEntity executeCaseEntity){
        int res = executeCaseService.addExecCase(executeCaseEntity);
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @PostMapping("/query")
    public QueryExecCasePageResponse queryExecuteCaseByPage(@RequestBody QueryExecCasePageRequest request){
        return executeCaseService.queryByPage(request);
    }

    @PostMapping("/update")
    public BaseResponse updateExecuteCase(@RequestBody ExecuteCaseEntity executeCaseEntity){
        int res = executeCaseService.updateById(executeCaseEntity);
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @PostMapping("/delete")
    public BaseResponse deleteExecuteCase(@RequestBody DeleteExecCaseRequest deleteExecCaseRequest){
        int res = executeCaseService.deleteBatchIds(deleteExecCaseRequest.getId());
        BaseResponse baseResponse = new BaseResponse();
        if (res == 0){
            baseResponse.setReturnMsg(Type.FAIL);
        }
        return baseResponse;
    }

    @PostMapping("/import")
    public BaseResponse importExcel(@RequestParam(value = "file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        BaseResponse baseResponse = new BaseResponse();
        if (StringUtils.isNotBlank(fileName) &&
                !fileName.matches("^.+\\.(?i)(xls)$")
                && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            baseResponse.setReturnMsg(Type.FAIL);
            baseResponse.setMsg("上传文件格式错误，请检查");
        }else {
            List<ExecuteCaseEntity> list = FileUtil.excelToObj(file, ExecuteCaseEntity.class);
            boolean flag = executeCaseService.insertBatchExecCase(list,null,null);
            if (!flag){
                baseResponse.setReturnMsg(Type.FAIL);
            }
        }
        return baseResponse;
    }

    @GetMapping("/export")
    public void exportExcel(@RequestParam(value = "type",required = false) String type, HttpServletResponse response){
        OutputStream outputStream = null;
        Workbook workbook = null;
        try {
            String fileName = FileUtil.getExcelFileName(type,"执行案例数据",true);
            response.addHeader("Content-Disposition", "filename=" + fileName);
            outputStream = response.getOutputStream();
            String[] titles = new String[]{"执行案例编号","批次号","案例描述","变量数据","是否启用","关联测试编号","前置执行案例编号","是否归档","执行次数","最后执行时间"};
            workbook = FileUtil.objToExcel(type,titles,executeCaseService.queryAllList());
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
