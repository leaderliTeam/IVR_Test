package com.pccc.sip.ivrtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pccc.sip.ivrtest.pojo.ExecCase;

public interface ExecCaseMapper extends BaseMapper<ExecCase> {

    ExecCase queryById(String id);

}