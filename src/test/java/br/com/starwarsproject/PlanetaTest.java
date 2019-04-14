package br.com.starwarsproject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import br.com.starwarsproject.model.Planeta;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlanetaTest {
	
	private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
	
    @Test
    public void testA_RetornoAparicoesSWAPI() throws Exception
    {
    	StringBuffer UrlBuffer = new StringBuffer();
		
		UrlBuffer.append("https://swapi.co/api/planets/?search=").append("Terra");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		ResponseEntity<Object> object = restTemplate.exchange(UrlBuffer.toString(), HttpMethod.GET,
					new HttpEntity<String>("parameters", headers), Object.class);
		
		assertEquals(object.getStatusCode(), HttpStatus.OK);
    }
    
    @Test
    public void testB_CadastrarSemNome() throws Exception {
        Planeta planeta = new Planeta();
        planeta.setNome("");
        planeta.setClima("tropical");
		planeta.setTerreno("arido");
		
        String json = new Gson().toJson(planeta);

        ResultActions response = mockMvc.perform(
                post("/api/planetas")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
        
                response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.erros").value("Nome não pode ser vazio"));
    }
    
    @Test
    public void testC_CadastrarSemClima() throws Exception {
        Planeta planeta = new Planeta();
        planeta.setNome("Terra");
        planeta.setClima("");
		planeta.setTerreno("arido");
		
        String json = new Gson().toJson(planeta);

        ResultActions response = mockMvc.perform(
                post("/api/planetas")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
        
                response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.erros").value("Clima não pode ser vazio"));
    }
    
    @Test
    public void testD_CadastrarSemTerreno() throws Exception {
        Planeta planeta = new Planeta();
        planeta.setNome("Terra");
        planeta.setClima("tropical");
    	planeta.setTerreno("");
		
        String json = new Gson().toJson(planeta);

        ResultActions response = mockMvc.perform(
                post("/api/planetas")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
        
                response.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.erros").value("Terreno não pode ser vazio"));
    }
    
    @Test
    public void testE_Cadastrar() throws Exception {
        Planeta planeta = new Planeta();
        planeta.setNome("Terra");
        planeta.setClima("tropical");
		planeta.setTerreno("arido");
		
        String json = new Gson().toJson(planeta);

        ResultActions response = mockMvc.perform(
                post("/api/planetas")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json));
        		
                response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.erros").doesNotExist());
    }
    
    @Test
    public void testF_ListarTodos() throws Exception {
        ResultActions response = mockMvc.perform(
                                                 get("/api/planetas")
                                                 .accept(MediaType.APPLICATION_JSON));

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.erros").doesNotExist());
    }
    
    @Test
    public void testG_PlanetaPorId() throws Exception
    {
    	
    	ResultActions response_planeta_existente = mockMvc.perform(
  	          get("/api/planetas/nome/{nome}", "Terra")
  	          .accept(MediaType.APPLICATION_JSON));
  	    	
  	    MvcResult result = response_planeta_existente.andReturn();
        JSONObject object = new JSONObject(result.getResponse().getContentAsString());
        JSONArray data = object.getJSONArray("data");
        JSONObject Item_data = data.getJSONObject(0); 
        String id = Item_data.getString("id");      
      
      
    	ResultActions response = mockMvc.perform(
          get("/api/planetas/{id}", id)
          .accept(MediaType.APPLICATION_JSON));
    	
          response.andDo(print())
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(id));
    }
    
    @Test
    public void testH_ListarPorNome() throws Exception
    {
    	ResultActions response = mockMvc.perform(
          get("/api/planetas/nome/{nome}", "Terra")
          .accept(MediaType.APPLICATION_JSON));
    	
          response.andDo(print())
          .andExpect(status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].nome", containsString("Terra")));
    }
    
    @Test
    public void testI_Remover() throws Exception
    {
    	
    	ResultActions response_planeta_existente = mockMvc.perform(
    	          get("/api/planetas/nome/{nome}", "Terra")
    	          .accept(MediaType.APPLICATION_JSON));
    	    	
    	MvcResult result = response_planeta_existente.andReturn();
        JSONObject object = new JSONObject(result.getResponse().getContentAsString());
        JSONArray data = object.getJSONArray("data");
        JSONObject Item_data = data.getJSONObject(0); 
        String id = Item_data.getString("id");          
    	
    	ResultActions response = mockMvc.perform(
    		                                     delete("/api/planetas/{id}", id));
                                                 
    	
    	response.andDo(print())
    	        .andExpect(status().isNoContent());
    }
    
    @Test
    public void testJ_RemoverInexistente() throws Exception
    {
    	
    	ResultActions response = mockMvc.perform(
    		                                     delete("/api/planetas/{id}", "uiyyy"));
                                                 
    	
    	response.andDo(print())
    	        .andExpect(status().isNoContent());
    }
}
