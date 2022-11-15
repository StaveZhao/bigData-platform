package com.bigData.common.log.annotation;

import java.lang.annotation.*;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAop {

    /** 模块 */
    String module() default "";

    /** 描述 */
    String value() default "";

}
