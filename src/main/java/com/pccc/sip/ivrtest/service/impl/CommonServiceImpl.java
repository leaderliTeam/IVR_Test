package com.pccc.sip.ivrtest.service.impl;

import com.pccc.sip.ivrtest.constant.Type;
import com.pccc.sip.ivrtest.mapper.ExecCaseMapper;
import com.pccc.sip.ivrtest.mapper.TestCaseMapper;
import com.pccc.sip.ivrtest.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ExecCaseMapper execCaseMapper;
    @Autowired
    private TestCaseMapper testCaseMapper;

    @Value("${case.serial.length}")
    private int length;

    private final static String IVR = "IVR";
    private final static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    private static HashMap<String,String> map = new HashMap<>();

    @Override
    public synchronized String creatExecCaseId() {
        String id = execCaseMapper.queryByLikeId(getIdPrefix(Type.EXECCASE.getType()));
        String execCaseId = map.get(getIdPrefix(Type.EXECCASE.getType()));
        if (StringUtils.isBlank(id)
                && StringUtils.isBlank(execCaseId)){
            id = getFirstCaseId(Type.EXECCASE.getType());
            clearCaseIdMap(Type.EXECCASE.getType());
        } else if(StringUtils.isNotBlank(execCaseId)
            && (StringUtils.isBlank(id) || compareId(execCaseId,id))){
                id = getNewCaseId(execCaseId);
        } else {
            id = getNewCaseId(id);
        }
        map.put(getIdPrefix(Type.EXECCASE.getType()),id);
        return id;
    }

    @Override
    public synchronized String creatTestCaseId() {
        String id = testCaseMapper.queryByLikeId(getIdPrefix(Type.TESTCASE.getType()));
        String testCaseId =  map.get(getIdPrefix(Type.TESTCASE.getType()));
        if (StringUtils.isBlank(id)
                && StringUtils.isBlank(testCaseId)){
            id = getFirstCaseId(Type.TESTCASE.getType());
            clearCaseIdMap(Type.TESTCASE.getType());
        } else if(StringUtils.isNotBlank(testCaseId)
                && (StringUtils.isBlank(id) || compareId(testCaseId,id))){
            id = getNewCaseId(testCaseId);
        } else {
            id = getNewCaseId(id);
        }
        map.put(getIdPrefix(Type.TESTCASE.getType()),id);
        return id;
    }

    @Override
    public String getTodayCaseIdOfNew(String type) {
        String id = null;
        if (StringUtils.equals(Type.TESTCASE.getType(),type)){
            id = testCaseMapper.queryByLikeId(getIdPrefix(type));
        }else{
            id = execCaseMapper.queryByLikeId(getIdPrefix(type));
        }
        String caseId = map.get(getIdPrefix(type));
        if (StringUtils.isNotBlank(caseId)
                && (StringUtils.isBlank(id) || compareId(caseId,id))){
            id = caseId;
        }
        return id;
    }

    public void clearCaseIdMap(String type) {
        map.entrySet().removeIf(map -> map.getKey().contains(IVR + type));
    }

    private String getIdPrefix(String type){
        return IVR + type + format.format(new Date());
    }

    private String getFirstCaseId(String type){
        return IVR + type + (Long.parseLong(format.format(new Date())) * getSerialNo() + 1);
    }

    private String getNewCaseId(String id){
        String prefix = id.substring(0,4);
        String suffix = id.substring(4);
        long suffixNum = Long.parseLong(suffix) + 1;
        return prefix + suffixNum;
    }

    private boolean compareId(String id,String dbId){
        long suffixId = Long.parseLong(id.substring(4));
        long suffixDbId = Long.parseLong(dbId.substring(4));
        return suffixId > suffixDbId;
    }

    private long getSerialNo(){
        long number = 1L;
        for (int i = 0 ;i < length;i++){
            number *= 10;
        }
        return number;
    }
}
