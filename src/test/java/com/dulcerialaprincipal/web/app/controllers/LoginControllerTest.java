package com.dulcerialaprincipal.web.app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Principal;

import org.junit.jupiter.api.Test;

class LoginControllerTest {

	@Test
	//Carga página
	void loginTest() {
		String retorno= "login";
		LoginController a = new LoginController();
		String result;
		result=a.login(null, null, null, null, null);
		assertEquals(retorno, result);
	}
	
	@Test
	void loginTestError() {
		String retorno= "redirect:/home";
		LoginController a = new LoginController();
		String result;
		Principal principal = new Principal() {
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "org.springframework.security.authentication.UsernamePasswordAuthenticationToken@9e9adef2: Principal: org.springframework.security.core.userdetails.User@21c2dcb8: Username: 1012466040; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_ADMIN; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@fffbcba8: RemoteIpAddress: 0:0:0:0:0:0:0:1; SessionId: FA28B072A918AC2FFEC2D4535053B3EF; Granted Authorities: ROLE_ADMIN";
			}
		};
		result=a.login(null, null, null, principal, null);
		assertEquals(retorno, result);
	}

}
