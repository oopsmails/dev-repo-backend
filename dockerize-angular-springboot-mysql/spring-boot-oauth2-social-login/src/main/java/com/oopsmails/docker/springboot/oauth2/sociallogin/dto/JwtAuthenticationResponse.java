package com.oopsmails.docker.springboot.oauth2.sociallogin.dto;

import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private String accessToken;
	private boolean authenticated;
	private UserInfo user;
}