package com.pccc.sip.ivrtest.engine;

import com.google.gson.JsonObject;
import com.pccc.sip.ivrtest.entity.ExecuteCaseEntity;
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

    public void executeCases(ExecuteCaseEntity executeCaseEntity) {
        logger.info(executeCaseEntity.getId());
        if (!StringUtils.equals("1", executeCaseEntity.getUsed())){
            return;
        }
        List<JsonObject> executeInfo = new ArrayList<>();
        JsonObject request = new JsonObject();
        Date startDate = new Date();
        ExecCaseResult execCaseResult = new ExecCaseResult();
        execCaseResult.setExecCaseId(executeCaseEntity.getId());
        try {
            execute(executeInfo, executeCaseEntity,request,false);
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
     * @param executeCaseEntity 执行案例数据
     * @param request 与客户端交互的最新的报文
     * @param preposition 是否前置标识
     */
    private void execute(List<JsonObject> executeInfo, ExecuteCaseEntity executeCaseEntity, JsonObject request, boolean preposition){

        //执行前置
        ExecCase execCase = new ExecCase();
        if (StringUtils.isNotBlank(executeCaseEntity.getExecuteId())){
            execCase = executeEngineService.queryExecCaseById(executeCaseEntity.getExecuteId());
            execute(executeInfo,execCaseToRequest(execCase),request,true);
        }

        TestCase testCase = executeEngineService.queryTestCaseById(executeCaseEntity.getCaseId());
        executeInfo.addAll(clientInteraction(fillData(executeCaseEntity.getVariableData(),testCase.getInputSeq()),preposition,request));

        //更新数据库
        Date date = new Date();
        testCase.setLastExecuteTime(date);
        execCase.setId(executeCaseEntity.getId());
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

    private ExecuteCaseEntity execCaseToRequest(ExecCase execCase){
        ExecuteCaseEntity executeCaseEntity = new ExecuteCaseEntity();
        executeCaseEntity.setId(execCase.getId());
        executeCaseEntity.setCaseId(execCase.getTestCaseId());
        executeCaseEntity.setExecuteId(execCase.getPreExecCaseId());
        executeCaseEntity.setUsed(execCase.getIsUsed());
        executeCaseEntity.setVariableData(GsonUtil.GsonToBean(execCase.getParams(),HashMap.class));
        return executeCaseEntity;
    }

}
