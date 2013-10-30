package com.firstProject.validation.validators;

import com.firstProject.validation.annotations.Unique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Author: Øyvind Bjerke
 * Date: 10/22/13
 * Time: 12:15 PM
 */
public class UniqueValidator implements ConstraintValidator<Unique,Object> {
	@PersistenceContext
	private EntityManager entityManager;
	private String propertyName;
	@Autowired
	private MessageSource messageSource;

	@Override
	public void initialize(Unique unique) {
		propertyName = unique.value();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<?> query = cb.createQuery(o.getClass());
		Root<?> root = query.from(o.getClass());

		Object propertyValue = getPropertyValue(o);
		Predicate propertyEqual = cb.equal(root.get(propertyName), propertyValue);
		Predicate idEqual = cb.equal(root.get("id"), propertyValue);
		query.where(propertyEqual);

		List<?> resultList = entityManager.createQuery(query).getResultList();
		for (Object abstractPersistable : resultList) {
			if (!abstractPersistable.equals(o) ) {
				constraintValidatorContext.disableDefaultConstraintViolation();
				String message = messageSource.getMessage("unique", new Object[]{propertyValue, propertyName}, LocaleContextHolder.getLocale());
				constraintValidatorContext.buildConstraintViolationWithTemplate(message).addNode(propertyName).addConstraintViolation();
				return false;
			}
		}
		return true;
	}

	private Object getPropertyValue(Object o) {
		Object o1 = null;
		try {
			Field declaredField = o.getClass().getDeclaredField(propertyName);
			declaredField.setAccessible(true);
			o1 = declaredField.get(o);
		} catch (NoSuchFieldException e) {

		} catch (IllegalAccessException e) {

		}
		return o1;
	}
}
