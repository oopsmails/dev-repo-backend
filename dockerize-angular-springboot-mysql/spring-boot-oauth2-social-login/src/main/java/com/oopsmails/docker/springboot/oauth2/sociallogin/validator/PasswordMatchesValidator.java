package com.oopsmails.docker.springboot.oauth2.sociallogin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.oopsmails.docker.springboot.oauth2.sociallogin.dto.SignUpRequest;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, SignUpRequest> {

	@Override
	public boolean isValid(final SignUpRequest user, final ConstraintValidatorContext context) {
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
