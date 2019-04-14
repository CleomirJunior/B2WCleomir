<img src="/docs/Star-Wars-Logo-9.png" alt="Teste" style="max-width:100%;">

<h2>API REST (Teste B2W)</h2>

Acessos:
- Adicionar um planeta (com nome, clima e terreno)
        Método HTTP: POST<br/>
	URI:  http://localhost:8080/api/planetas<br/>
	Body: { "nome": "Alderaan", "clima": "temperate", "terreno": "grasslands, mountains" }<br/>

- Listar planetas<br/>
        Método HTTP: GET<br/>
	URI: http://localhost:8080/api/planetas<br/>

- Buscar por nome<br/>
        Método HTTP: GET<br/>
	URI: http://localhost:8080/api/planetas/nome/{nome}<br/>

- Buscar por ID<br/>
        Método HTTP: GET<br/>
	URI: http://localhost:8080/api/planetas/{id}<br/>

- Remover planeta<br/>
        Método HTTP: DELETE<br/>
	URI: http://localhost:8080/api/planetas/{id}<br/>

Arquitetura utilizanda no desenvolvimento do  Back-End:

Java, Spring Boot e Springframework Data MongoDB

IDE de desenvolvimento: STS

Foram mantidas as configurações de acordo com o padrão do MongoDB.
Nome do DataBase configurado no application.properties: starwarsDB

O Consumo da API pública do Star Wars foi praticado a cada vez que há uma interação de cadastro ou consulta de um planeta, de forma que a quantidade de aparições em filmes não é persistida no banco somente é apresentada ao usuário, mantendo sempre uma informação atualizada


<h2>Exemplo de Teste</h2>


- Adicionar um planeta (com nome, clima e terreno)<br/>
Método HTTP: POST<br/>
URI Utilizada: http://localhost:8080/api/planetas<br/>
Status da execução esperado: 201 Created<br/>

<img src="/docs/adicionar_planeta.PNG" alt="Teste" style="max-width:100%;">
<br/>
<br/>
<br/>

- Listar planetas<br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas<br/>
	Status da execução esperado: 200 OK<br/>
	

<img src="/docs/listar-planetas.PNG" alt="Teste" style="max-width:100%;">
<br/>
<br/>
<br/>

- Buscar por nome<br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas/nome/Yavin IV<br/>
	Status da execução esperado: 200 OK<br/>
	
	<img src="/docs/buscar-nome.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

- Buscar por ID<br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa4939d50481fe4c0120e<br/>
	Status da execução esperado: 200 OK<br/>
	
	<img src="/docs/bucar-id.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

- Remover planeta<br/>
        Método HTTP: DELETE<br/>
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa3979d50481fe4c0120c<br/>
	Status da execução esperado: 204 No Content<br/>
	
	<img src="/docs/remover-planeta.PNG" alt="Teste" style="max-width:100%;">
