package com.oopsmails.docker.springboot.oauth2.sociallogin.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.oopsmails.docker.springboot.oauth2.sociallogin.dto.LocalUser;
import com.oopsmails.docker.springboot.oauth2.sociallogin.dto.SignUpRequest;
import com.oopsmails.docker.springboot.oauth2.sociallogin.exception.UserAlreadyExistAuthenticationException;
import com.oopsmails.docker.springboot.oauth2.sociallogin.model.User;

/**
 * @author Chinna
 * @since 26/3/18
 */
public interface UserService {

	public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}
