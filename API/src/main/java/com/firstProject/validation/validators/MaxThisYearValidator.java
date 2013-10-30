package com.firstProject.validation.validators;

import com.firstProject.validation.annotations.MaxThisYear;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

/**
 * Author: Øyvind Bjerke
 * Date: 10/24/13
 * Time: 1:58 PM
 */
public class MaxThisYearValidator implements ConstraintValidator<MaxThisYear, Integer> {

	private Integer currentYear;

	@Override
	public void initialize(MaxThisYear maxThisYear) {
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
	}

	@Override
	public boolean isValid(Integer yearField, ConstraintValidatorContext constraintValidatorContext) {
		if(yearField == null){
			return true;
		}
		if(yearField < currentYear){
			return true;
		}
		return false;
	}
}
