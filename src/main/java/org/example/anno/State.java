package org.example.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import org.example.validation.StateValidation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented//元注解
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(
        validatedBy = {StateValidation.class}
)//指定提供校验规则的类
public @interface State {
    //校验失败的提示信息
    String message() default "state参数的值只能是已发布的文章或者草稿";
    //指定分组
    Class<?>[] groups() default {};
    //负载
    Class<? extends Payload>[] payload() default {};
}
