package com.pccc.sip.ivrtest.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCaseResult;

public interface ExecCaseResultMapper extends BaseMapper<ExecCaseResult> {

    ExecCaseResult queryById(String id);
    int addExecCaseResult(ExecCaseResult execCaseResult);

}