package com.ywg.hikdev.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ywg
 * @date 2024-3-20 11:01
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckDeviceLogin {
    String operation() default "deviceSn";
}
