package com.dulcerialaprincipal.web.app.controllers;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DulceriaController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value = { "/home", "/" })
	public String home(Authentication authentication) {
		if (authentication != null) {
			logger.info("Hola, el usuario autenticado por DulceriaController es: ".concat(authentication.getName()));
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			logger.info("Hola, el usuario autenticado por DulceriaController utilizando forma estática es: "
					.concat(authentication.getName()));
		}
		if (hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso"));
		}
		else
		{
			logger.info("Hola ".concat(auth.getName()).concat(" NO tienes acceso"));
		}
		return "home";
	}

	private boolean hasRole(String rol) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null) {
			return false;
		}
		Authentication auth = context.getAuthentication();
		if (auth == null) {
			return false;
		}
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (rol.equals(authority.getAuthority())) {
				logger.info("Hola usuario ".concat(auth.getName()).concat(" tu rol es: ").concat(authority.getAuthority()));
				return true;
			}
		}
		return false;

	}

	@RequestMapping(value = "/home/homeproducto")
	public String homeproducto() {

		return "homeproducto";
	}

	@RequestMapping(value = "/home/homecompra")
	public String homecompra() {

		return "homecompra";
	}

	@RequestMapping(value = "/home/homeventa")
	public String homeventa() {

		return "homeventa";
	}

}
