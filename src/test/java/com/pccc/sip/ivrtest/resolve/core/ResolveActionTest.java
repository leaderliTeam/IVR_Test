package com.pccc.sip.ivrtest.resolve.core;

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
        String regex = "\\$\\{(.*?)}";

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher("123${abc}9089012${cba}");
        while (matcher.find()) {
            String group = matcher.group(1);
            System.out.println(matcher.groupCount());
            System.out.println(group);
        }

    }

    @Test
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

    @Test
    public void test4() {
        String str = "123${abc}9089012${cba}";

        Map<String, String> map = new HashMap<>();
        map.put("abc", "---");
        map.put("cba", "+++");

        StringSubstitutor stringSubstitutor = new StringSubstitutor(map);

        String msg = stringSubstitutor.replace(str);

        System.out.println(msg);
    }

    @Test
    public void test5() {
        String str = "123#abc#abc#cba#123";

        Map<String, String> map = new HashMap<>();
        map.put("abc", "---");
        map.put("cba", "+++");

        StringSubstitutor stringSubstitutor = new StringSubstitutor(map, "#", "#");

        String msg = stringSubstitutor.replace(str);

        System.out.println(msg);
    }

}
