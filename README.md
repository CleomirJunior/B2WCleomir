Acessos:
- Adicionar um planeta (com nome, clima e terreno) - POST
	URI:  http://localhost:8080/api/planetas
	Body: { "nome": "Alderaan", "clima": "temperate", "terreno": "grasslands, mountains" }

- Listar planetas - GET
	URI: http://localhost:8080/api/planetas

- Buscar por nome - GET
	URI: http://localhost:8080/api/planetas/nome/{nome}

- Buscar por ID - GET
	URI: http://localhost:8080/api/planetas/{id}

- Remover planeta - DELETE
	URI: http://localhost:8080/api/planetas/{id}

Arquitetura utilizanda no desenvolvimento do  Back-End:

Java, Spring Boot e Springframework Data MongoDB

IDE de desenvolvimento: STS

Foram mantidas as configurações de acordo com o padrão do MongoDB.
Nome do DataBase configurado no application.properties: starwarsDB

O Consumo da API pública do Star Wars foi praticado a cada vez que há uma interação de cadastro ou consulta de um planeta, de forma que a quantidade de aparições em filmes não é persistida no banco somente é apresentada ao usuário, mantendo sempre uma informação atualizada

