package com.api.demo.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValueRequiredValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValueRequired {

    String message() default "{message.custom.validacion.password}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
