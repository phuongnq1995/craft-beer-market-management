package org.assignment.app.validator;

import org.assignment.app.form.AuthForm;
import org.assignment.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Phuongnq
 * Auth form validator
 */
@Component
public class AuthValidator implements Validator {

	@Autowired
	UserService userService;

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return AuthForm.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		AuthForm accountForm = (AuthForm) target;

		// Check match password
		if(!accountForm.getPassword().equals(accountForm.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "user.notmatch.passwordConfirm");
		}

		// Check exists username
		if(userService.exists(accountForm.getUsername())) {
			errors.rejectValue("username", "user.exists.username");
		}
	}

}
