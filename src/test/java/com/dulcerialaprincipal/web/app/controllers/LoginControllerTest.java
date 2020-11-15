package com.dulcerialaprincipal.web.app.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Principal;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

class LoginControllerTest {

	@Test
	//Carga página
	void loginTest() {
		String retorno= "login";
		LoginController a = new LoginController();
		String result=a.login(null, null, null, null, null);
		assertEquals(retorno, result);
	}
	
	@Test
	void loginTestError() {
		String retorno= "redirect:/home";
		LoginController a = new LoginController();
		Principal principal = new Principal() {
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "1012466040";
			}
		};
		String result=a.login(null, null, null, principal, null);
		assertEquals(retorno, result);
	}

}
