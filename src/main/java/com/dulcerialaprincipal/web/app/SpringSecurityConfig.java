package com.dulcerialaprincipal.web.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.dulcerialaprincipal.web.app.auth.handler.LoginSuccessHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private LoginSuccessHandler successHandler;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().antMatchers("/home/**")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().successHandler(successHandler)
				.loginPage("/login").permitAll().and().logout().permitAll();

	}

	@Autowired
	public void configuracionGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("select * from usuario where idusuario=?").authoritiesByUsernameQuery(
						"select u.idusuario,r.nombre from rol r inner join usuario u on(u.rol_idrol=r.idrol) where u.idusuario=?");
	}

}