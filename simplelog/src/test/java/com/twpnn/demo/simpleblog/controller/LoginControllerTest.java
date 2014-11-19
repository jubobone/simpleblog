package com.twpnn.demo.simpleblog.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.twpnn.demo.simpleblog.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class LoginControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private Filter springSecurityFilterChain;

	private MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).addFilters(springSecurityFilterChain).build();
	}

	@Test
    public void testLogin() throws Exception {
        this.mvc.perform(formLogin("/login").user("testuser").password("password"));
    }

	@Test
    public void testAuthorizeUser() throws Exception {
        this.mvc.perform(formLogin().user("testuser")).andExpect(authenticated().withRoles("USER"));
    }
	
	@Test
    public void testAuthenticateSuccess() throws Exception {
        this.mvc.perform(formLogin()).andExpect(status().isOk()).andExpect(redirectedUrl("/greetings")).andExpect(authenticated().withUsername("testuser"));
    }
	
	@Test
    public void testLogout() throws Exception {
        this.mvc.perform(logout("/logout"));
    }
	
	@Configuration
	@EnableWebMvcSecurity
	@EnableWebMvc
	static class Config extends WebSecurityConfigurerAdapter {
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth)
				throws Exception {
			auth.inMemoryAuthentication().withUser("testuser").password("password")
					.roles("USER");
		}
	}
}