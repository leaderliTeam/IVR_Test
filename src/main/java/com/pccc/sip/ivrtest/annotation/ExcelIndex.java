package com.pccc.sip.ivrtest.annotation;

import com.pccc.sip.ivrtest.constant.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * index 标记元素在 excel表格中的行所在位置
 * type 标记元素的类型，区别是否需要特殊处理
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelIndex {

    int index();

    Type.AttributeType type() default Type.AttributeType.STRING;

}
