package br.com.starwarsproject.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starwarsproject.model.Planeta; 

public interface PlanetaRepository extends MongoRepository<Planeta, String>{

	public List<Planeta> findByNomeLikeIgnoreCase(String nome);
	
}
