package com.tavant.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tavant.domain.User;

public class RegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "required.emailId", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password", "Field name is required.");

	}

}
