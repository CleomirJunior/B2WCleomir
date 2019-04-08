package br.com.starwarsproject.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.starwarsproject.model.Planeta;
import br.com.starwarsproject.repositories.PlanetaRepository;

@Service
public class PlanetaService {
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	public List<Planeta> listarTodos() {
		List<Planeta> planetas = this.planetaRepository.findAll();
		
		for(Planeta planeta : planetas) {
			planeta.setNumeroApraricoes(buscarAparicoesNosFilmes(planeta.getNome()));
		}
		
		return planetas;
	}

	public Planeta planetaPorId(String id) {
		try {
			Planeta planeta = this.planetaRepository.findById(id).get();
			
			if(planeta != null)
				planeta.setNumeroApraricoes(buscarAparicoesNosFilmes(planeta.getNome()));
			return planeta;
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Planeta> planetaPorNome(String nome) {
		List<Planeta> planetas = this.planetaRepository.findByNomeLikeIgnoreCase(nome);
		
		for(Planeta planeta : planetas) {
			planeta.setNumeroApraricoes(buscarAparicoesNosFilmes(planeta.getNome()));
		}
		
		return planetas;
	}

	public Planeta cadastrar(Planeta planeta) {
		Planeta planetaCadastrado = this.planetaRepository.save(planeta);
		if(planetaCadastrado != null)
			planeta.setNumeroApraricoes(buscarAparicoesNosFilmes(planeta.getNome()));
		return planetaCadastrado;
	}

	public void remover(String id) {
		this.planetaRepository.deleteById(id);
	}
	
	private Integer buscarAparicoesNosFilmes(String name) {
		
		StringBuffer UrlBuffer = new StringBuffer();
		
		UrlBuffer.append("https://swapi.co/api/planets/?search=").append(name);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		Object object;
		try {
			object = restTemplate.exchange(UrlBuffer.toString(), HttpMethod.GET,
					new HttpEntity<String>("parameters", headers), Object.class);
		} catch (Exception e) {
			return null;
		}

		Gson gson = new Gson();
		JsonArray results = gson.fromJson(gson.toJson(object), JsonObject.class).getAsJsonObject("body")
				.getAsJsonArray("results");

		JsonElement correctResult = null;

		for (JsonElement e : results) {
			if (e.getAsJsonObject().get("name").getAsString().equalsIgnoreCase(name)) {
				correctResult = e;
			}
		}

		if (correctResult == null) {
			return 0;
		} else {
			return correctResult.getAsJsonObject().getAsJsonArray("films").size();
		}
	}
}
