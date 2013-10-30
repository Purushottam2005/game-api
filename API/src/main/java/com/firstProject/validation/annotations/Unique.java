package com.firstProject.validation.annotations;

import com.firstProject.validation.validators.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author: Øyvind Bjerke
 * Date: 10/22/13
 * Time: 12:12 PM
 */
@Documented
@Constraint(validatedBy = {UniqueValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface Unique {
	String value();

	String message() default "unused";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
