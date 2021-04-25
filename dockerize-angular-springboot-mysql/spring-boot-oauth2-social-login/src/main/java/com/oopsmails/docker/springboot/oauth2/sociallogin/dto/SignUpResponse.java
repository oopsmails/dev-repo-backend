package com.oopsmails.docker.springboot.oauth2.sociallogin.dto;

import lombok.Value;

@Value
public class SignUpResponse {
	private boolean using2FA;
	private String qrCodeImage;
}