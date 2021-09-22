package com.sdcc.gpao.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestSecurity {

	@Autowired
	private WebApplicationContext context;  
	@Autowired
	private MockMvc mvc;

	@Test
	public void testUnauthorized() throws Exception{
	    MockMvcBuilders.webAppContextSetup(this.context)
	                        .apply(SecurityMockMvcConfigurers.springSecurity())
	                        .build();
	    				this.mvc
	                    .perform(get("/api/chauffeur/liste").with(httpBasic("usine","usi")))
	                    .andDo(print())
	                    .andExpect(status().isUnauthorized())
	                    .andReturn();
	}
	
	@Test
	public void testForbiden() throws Exception{
	    MockMvcBuilders.webAppContextSetup(this.context)
	                        .apply(SecurityMockMvcConfigurers.springSecurity())
	                        .build();
	    				this.mvc
	                    .perform(get("/api/chauffeur/liste").with(httpBasic("prod","prod")))
	                    .andDo(print())
	                    .andExpect(status().isForbidden())
	                    .andReturn();
	}
	
	@Test
	public void testGranted() throws Exception{
	    MockMvcBuilders.webAppContextSetup(this.context)
	                        .apply(SecurityMockMvcConfigurers.springSecurity())
	                        .build();
	    				this.mvc
	                    .perform(get("/api/chauffeur/liste").with(httpBasic("usine","usine")))
	                    .andDo(print())
	                    .andExpect(status().isFound())
	                    .andReturn();
	}
}
