<h2>API REST (Teste B2W)</h2>

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


<h2>Exemplo de Teste</h2>


- Adicionar um planeta (com nome, clima e terreno) - POST
URI Utilizada: http://localhost:8080/api/planetas

<img src="/docs/adicionar_planeta.PNG" alt="Teste" style="max-width:100%;">
<br/>
<hr/>
<br/>

- Listar planetas - GET
	URI Utilizada: http://localhost:8080/api/planetas

<img src="/docs/listar-planetas.PNG" alt="Teste" style="max-width:100%;">
<br/>
<br/>
<br/>

- Buscar por nome - GET
	URI Utilizada: http://localhost:8080/api/planetas/nome/Yavin IV
	
	<img src="/docs/buscar-nome.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

- Buscar por ID - GET
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa4939d50481fe4c0120e
	
	<img src="/docs/bucar-id.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

- Remover planeta - DELETE
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa3979d50481fe4c0120c
	<img src="/docs/remover-planeta.PNG" alt="Teste" style="max-width:100%;">
