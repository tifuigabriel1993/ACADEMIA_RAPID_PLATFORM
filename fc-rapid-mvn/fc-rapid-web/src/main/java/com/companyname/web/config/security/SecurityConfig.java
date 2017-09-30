package com.companyname.web.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import com.companyname.service.business.platform.SocialUsersDetailServiceImpl;
import com.companyname.web.util.Urls;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		http.formLogin().loginPage("/login").successHandler(authenticationSuccessRoleHandler()).and()
				.apply(getSpringSocialConfigurer());
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("SESSION")
				.logoutSuccessHandler(logoutSuccessHandler());
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**", "/img/**", "/files/**")
				.permitAll();
	}

	@Bean
	public SpringSocialConfigurer getSpringSocialConfigurer() {
		SpringSocialConfigurer config = new SpringSocialConfigurer();
		config.alwaysUsePostLoginUrl(true);
		config.postLoginUrl(Urls.AFTER_LOGIN_REDIRECT);
		return config;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public SocialUserDetailsService socialUsersDetailService() {
		return new SocialUsersDetailServiceImpl();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationSuccessRoleHandler authenticationSuccessRoleHandler() {
		return new AuthenticationSuccessRoleHandler();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new LogoutSuccessHandler();
	}

}