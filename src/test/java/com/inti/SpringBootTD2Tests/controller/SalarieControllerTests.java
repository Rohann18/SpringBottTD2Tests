package com.inti.SpringBootTD2Tests.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.inti.SpringBootTD2Tests.repository.SalarieRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = SalarieController.class)
public class SalarieControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SalarieRepository salaireRepository;
	
	@Test
	@DisplayName("Test affichage de tous les salariés")
	public void testAffichageAllSalarie() {
		try {
			mockMvc.perform(get("/salaries"))
				.andExpect(status().isOk())
				.andExpect(view().name("listeSalarie"))
				.andExpect(content().string(containsString("Email")))
				.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
