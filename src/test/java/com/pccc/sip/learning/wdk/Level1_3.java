package com.pccc.sip.learning.wdk;

import org.junit.Test;

public class Level1_3 {
    @Test
    public void test1() {
            byte b = 1;
            short s = 200;
            int i = 300;
            long l = 400;

            /*如果试图给byte类型的变量赋予超出其范围的值，就会产生编译错误*/
            byte b2 = (byte) 140;
            System.out.println(b2);
    }
}
