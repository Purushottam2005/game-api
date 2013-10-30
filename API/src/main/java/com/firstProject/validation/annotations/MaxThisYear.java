package com.firstProject.validation.annotations;

import com.firstProject.validation.validators.MaxThisYearValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Author: Øyvind Bjerke
 * Date: 10/24/13
 * Time: 1:53 PM
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MaxThisYearValidator.class})
public @interface
		MaxThisYear {
	java.lang.String message() default "{javax.validation.constraints.MaxThisYear.message}";

	java.lang.Class<?>[] groups() default {};

	java.lang.Class<? extends javax.validation.Payload>[] payload() default {};
}
