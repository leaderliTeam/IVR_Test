package com.pccc.sip.ivrtest.resolve;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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

    @Test
    public void test2() {
        String replace = StringUtils.replace("123123123", "2", "3");
        System.out.println(replace);
    }


}