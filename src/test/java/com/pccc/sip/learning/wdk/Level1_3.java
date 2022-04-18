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

        char c = 'A';
        short s2 = 80;

        //虽然short和char都是16位的，长度是一样的
        //但是彼此之间，依然需要进行强制转换
        s=(short) c;
        System.out.println(s);
    }

    @Test
    public void test2() {
        int hexVal = 0x1a; //16进制
        int oxVal = 032; //8进制
        int binVal = 0b11010; //2进制
        System.out.println(hexVal);
        System.out.println(oxVal);
        System.out.println(binVal);

    }
}
