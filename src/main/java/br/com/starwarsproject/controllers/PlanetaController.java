package br.com.starwarsproject.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.starwarsproject.model.Planeta;
import br.com.starwarsproject.responses.Response;
import br.com.starwarsproject.services.PlanetaService;


@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {
	
	@Autowired
	private PlanetaService planetaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Planeta>>> listarTodos(){
		
		List<Planeta> planetas = this.planetaService.listarTodos();
		
		if (planetas.size() > 0) {
			return ResponseEntity.ok(new Response<List<Planeta>>(planetas));
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> planetaPorId(@PathVariable(name = "id") String id){
		
		Planeta planeta = this.planetaService.planetaPorId(id);
		
		if (planeta != null) {
			return ResponseEntity.ok(new Response<Planeta>(this.planetaService.planetaPorId(id)));
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(value = "/nome/{nome}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Planeta>>> listarPorNome(@PathVariable(name = "nome") String nome){
		
		List<Planeta> planetas = this.planetaService.planetaPorNome(nome);
		
		if (planetas.size() > 0) {
			return ResponseEntity.ok(new Response<List<Planeta>>(planetas));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result){
		
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		Planeta planetaCadastrado = this.planetaService.cadastrar(planeta);
		
		if (planetaCadastrado != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response<Planeta>(planetaCadastrado));
		} else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable(name = "id") String id){
		this.planetaService.remover(id);
	}
}
