package com.api.demo.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueRequiredValidator implements ConstraintValidator<ValueRequired, String> {
    @Override
    public void initialize(ValueRequired constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        // Value cannot be Null nor Empty
        return value != null && !value.isEmpty();
    }
}
