package br.com.pessoa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveListarPessoasComSucesso() throws Exception {
		mockMvc.perform(get("/pessoas"))
		.andExpect(status().isOk());
	}
}
