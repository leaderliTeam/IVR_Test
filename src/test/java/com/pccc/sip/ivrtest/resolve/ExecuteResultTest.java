package com.pccc.sip.ivrtest.resolve;

import com.pccc.sip.ivrtest.resolve.core.ResolveAction;
import com.pccc.sip.ivrtest.resolve.core.ResolveChain;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class ExecuteResultTest {

    @Test
    public void test1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("accNo", "622225874443221");
        map.put("flowCode", "N10001");

        //language=JSON
        String str = "[\n" +
                "  {\n" +
                "    \"input\": \"${accNo}\",\n" +
                "    \"output\": \"voice|10410;voice|10651\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"input\": \"${flowCode}\",\n" +
                "    \"output\": \"voice|11111\"\n" +
                "  }\n" +
                "]";

        ResolveAction resolveAction = new ResolveAction();
        ResolveChain chain = resolveAction.resolveRule(str, map);

        //language=JSON
        String execResult = "{\n" +
                "  \"executeInfo\": [\n" +
                "    {\n" +
                "      \"type\": \"input\",\n" +
                "      \"value\": \"622225874443221\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"wav\",\n" +
                "      \"value\": \"10410#请输入查询密码，按#号键确认\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"wav\",\n" +
                "      \"value\": \"10651#如您忘记查询密码请按1#号键\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"input\",\n" +
                "      \"value\": \"1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"vdn\",\n" +
                "      \"value\": \"56301\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"input\",\n" +
                "      \"value\": \"N10001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"seq\",\n" +
                "      \"value\": \"1-2-3\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"wav\",\n" +
                "      \"value\": \"11111#你好\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        ExecuteResult executeResult = new ExecuteResult(execResult);

        ResolveResult resolveResult = new ResolveResult();
        executeResult.match(resolveResult, chain.getItems());


    }

}