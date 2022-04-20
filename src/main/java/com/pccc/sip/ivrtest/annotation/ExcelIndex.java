package com.pccc.sip.ivrtest.annotation;

import com.pccc.sip.ivrtest.constant.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelIndex {

    int index();

    Type.AttributeType type() default Type.AttributeType.STRING;

}
