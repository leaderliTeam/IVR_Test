package com.pccc.sip.ivrtest.resolve;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolveActionTest {

    @Test
    public void test1() {
        String regex = "\\$\\{(.*?)\\}";

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher("123${abc}9089012${cba}");
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(matcher.groupCount());
            System.out.println(group);
        }

    }

    @org.junit.jupiter.api.Test
    public void test3() {
        Map<String, String> values = new HashMap<>();
        values.put("abc","---->");
        values.put("cba","+++++++++++");
        String message = StringSubstitutor.replace("123${abc}9089012${cba}", values);
        System.out.println(message);
    }

    @Test
    public void test2() {
        String replace = StringUtils.replace("123123123", "2", "3");
        System.out.println(replace);
    }


}
