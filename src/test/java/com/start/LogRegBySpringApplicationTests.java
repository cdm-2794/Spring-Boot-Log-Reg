package com.start;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.start.services.UserService;

@SpringBootTest
class LogRegBySpringApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService UserService;
	
	@Test
	void contextLoads() throws Exception {
		
		Mockito.when(UserService.showallUser()).thenReturn(Collections.EMPTY_LIST);
		
		MvcResult mvcResult =mockMvc.perform(MockMvcRequestBuilders.get("/all/")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		
		System.out.println("Testing " + mvcResult.getResponse());
		Mockito.verify(UserService).showallUser();
	}

}
