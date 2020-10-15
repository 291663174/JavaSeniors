package com.wuhen.java1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-13 17:58
 **/
@Target({TYPE, FIELD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
