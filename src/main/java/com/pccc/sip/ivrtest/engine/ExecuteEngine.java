package com.pccc.sip.ivrtest.engine;

import com.google.gson.JsonObject;
import com.pccc.sip.ivrtest.entity.ExecuteCaseRequest;
import com.pccc.sip.ivrtest.pojo.ExecCase;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;
import com.pccc.sip.ivrtest.pojo.TestCase;
import com.pccc.sip.ivrtest.service.ExecuteEngineService;
import com.pccc.sip.ivrtest.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class ExecuteEngine {

    private static final Logger logger = LoggerFactory.getLogger(ExecuteEngine.class);

    @Autowired
    private ExecuteEngineService executeEngineService;

    public void executeCases(ExecuteCaseRequest executeCaseRequest) {
        logger.info(executeCaseRequest.getId());
        if (!StringUtils.equals("1",executeCaseRequest.getUsed())){
            return;
        }
        List<JsonObject> executeInfo = new ArrayList<>();
        JsonObject request = new JsonObject();
        Date startDate = new Date();
        ExecCaseResult execCaseResult = new ExecCaseResult();
        execCaseResult.setExecCaseId(executeCaseRequest.getId());
        try {
            execute(executeInfo,executeCaseRequest,request,false);
            execCaseResult.setCallId("");
            //TODO
            execCaseResult.setExecInfo(GsonUtil.readerArrayJson("json/execInfo.json"));
            //TODO 执行详情规则解析
            HashMap<String,String> execResult = new HashMap<>();

            //TODO 更新执行结果表
            execCaseResult.setExecState("S");
            execCaseResult.setExecResult(GsonUtil.GsonString(execResult));
        } catch (Exception e) {
            logger.error(" ExecuteEngine executeCases execute error ",e);
            execCaseResult.setExecState("F");
        }finally {
            execCaseResult.setStartTime(startDate);
            execCaseResult.setEndTime(new Date());
            executeEngineService.addExecCaseResult(execCaseResult);
        }

    }

    /**
     *执行案例，交互客户端，更新数据库
     * @param executeInfo 执行详情集
     * @param executeCaseRequest 执行案例数据
     * @param request 与客户端交互的最新的报文
     * @param preposition 是否前置标识
     */
    private void execute(List<JsonObject> executeInfo, ExecuteCaseRequest executeCaseRequest,JsonObject request,boolean preposition){

        //执行前置
        ExecCase execCase = new ExecCase();
        if (StringUtils.isNotBlank(executeCaseRequest.getExecuteId())){
            execCase = executeEngineService.queryExecCaseById(executeCaseRequest.getExecuteId());
            execute(executeInfo,execCaseToRequest(execCase),request,true);
        }

        TestCase testCase = executeEngineService.queryTestCaseById(executeCaseRequest.getCaseId());
        executeInfo.addAll(clientInteraction(fillData(executeCaseRequest.getVariableData(),testCase.getInputSeq()),preposition,request));

        //更新数据库
        Date date = new Date();
        testCase.setLastExecuteTime(date);
        execCase.setId(executeCaseRequest.getId());
        execCase.setLastTime(date);
        executeEngineService.modifyCaseById(testCase,execCase);
    }

    /**
     *客户端交互
     * @param steps 交互步骤
     * @param preposition 是否前置标识
     * @param request 与客户端交互的最新的报文
     * @return
     */
    private List<JsonObject> clientInteraction(String[] steps,boolean preposition,JsonObject request){
        List<JsonObject> jsonObjects = new ArrayList<>();
        for (int i = 0; i < steps.length; i++) {
            String input = steps[i];
            //TODO 客户端交互 request：交互完更新成模拟客户端的返回报文并更新数据
            request = new JsonObject();
            JsonObject jsonObject = new JsonObject();
            jsonObjects.add(jsonObject);
        }
        if (!preposition){
            //TODO 非前置案例挂机

        }
        return jsonObjects;
    }

    /**
     * 组装变量数据
     * @param variableData 变量列表
     * @param inputSeq 序列
     * @return
     */
    private String[] fillData(HashMap<String,String> variableData, String inputSeq) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strings = inputSeq.split("\\|");
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (variableData.keySet().contains(key)) {
                int index = map.get(key) == null ? 0 : map.get(key);
                String[] values = variableData.get(key).split("\\|");
                strings[i] = values[index];
                map.put(key,index+1);
            }
        }
        return strings;
    }

    private ExecuteCaseRequest execCaseToRequest(ExecCase execCase){
        ExecuteCaseRequest executeCaseRequest = new ExecuteCaseRequest();
        executeCaseRequest.setId(execCase.getId());
        executeCaseRequest.setCaseId(execCase.getTestCaseId());
        executeCaseRequest.setExecuteId(execCase.getPreExecCaseId());
        executeCaseRequest.setUsed(execCase.getIsUsed());
        executeCaseRequest.setVariableData(GsonUtil.GsonToBean(execCase.getParams(),HashMap.class));
        return executeCaseRequest;
    }

}
