<img src="/docs/Star-Wars-Logo-9.png" alt="Teste" style="max-width:100%;">

<h1 align="center">API REST (Teste B2W)</h1>

<h2>Índice</h2>
<ol>
  <li><a href="#Objetivo">Objetivo do projeto</a></li>
  <li><a href="#Arquitetura">Arquitetura utilizanda no desenvolvimento do  Back-End:</a></li>
  <li><a href="#Serviços">Serviços disponibilizados</a></li>
  <li><a href="#Evidências">Evidências de Teste</a></li>
  <ul>
	<li><a href="#Adicionar">Adicionar um planeta</a></li>
	<li><a href="#Listar">Listar planetas</a></li>
	<li><a href="#BuscarNome">Buscar por nome</a></li>
	<li><a href="#BuscarID">Buscar por ID</a></li>
	<li><a href="#Remover">Remover planeta</a></li>
	<li><a href="#AdicionarSemNome">Adicionar um planeta sem Nome</a></li>
	<li><a href="#AdicionarSemClima">Adicionar um planeta sem Clima</a></li>
	<li><a href="#AdicionarSemTerreno">Adicionar um planeta sem Terreno</a></li>
  </ul>
</ol>

<h3><a name="Objetivo">1. Objetivo do projeto</a></h3>
<p>Criar uma API rest, que será consumido por um jogo, e armazenará o nome, clima e terreno de um planeta. O mesmo exibirá também a quantidade de aparições de cada planeta nos filmes de Star Wars, que será buscada na API SWAPI.</p>

<h3><a name="Arquitetura">2. Arquitetura utilizanda no desenvolvimento do  Back-End:</a></h3>

<ul>
  <li>Java, Spring Boot e Springframework Data MongoDB</li>

  <li>IDE de desenvolvimento: STS</li>

<li>Foram mantidas as configurações de acordo com o padrão do MongoDB.</li>
<li>Nome do DataBase configurado no application.properties: starwarsDB</li>
<br/>
<p>O Consumo da API pública do Star Wars foi praticado a cada vez que há uma interação de cadastro ou consulta de um planeta, de forma que a quantidade de aparições em filmes não é persistida no banco somente é apresentada ao usuário, mantendo sempre uma informação atualizada</p>
</ul>

<h3><a name="Serviços">3. Serviços disponibilizados</a></h3>

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
	
	<h3>Ações</h3>
	
<table>
<thead>
<tr>
<th align="left">Caminho</th>
<th align="center">Método</th>
<th align="center">Status</th>
<th align="left">Descrição</th>
</tr>
</thead>
<tbody>
<tr>
<td align="left"><code>/api/planetas/</code></td>
<td align="center"><code>POST</code></td>
<td align="center">201</td>
<td align="left">Adicionar um planeta</td>
</tr>
<tr>
<td align="left"><code>/api/planetas/</code></td>
<td align="center"><code>GET</code></td>
<td align="center">200</td>
<td align="left">Listar planetas</td>
</tr>
<tr>
<td align="left"><code>/api/planetas/nome/:nome</code></td>
<td align="center"><code>GET</code></td>
<td align="center">200</td>
<td align="left">Buscar por nome</td>
</tr>
<tr>
<td align="left"><code>/api/planetas/:id</code></td>
<td align="center"><code>GET</code></td>
<td align="center">200</td>
<td align="left">Buscar por ID</td>
</tr>
<tr>
<td align="left"><code>/api/planetas/:id</code></td>
<td align="center"><code>DELETE</code></td>
<td align="center">204</td>
<td align="left">Remover planeta</td>
</tr>
</tbody>
</table>

<br/>
	

<h2><a name="Evidências">4. Evidências de Teste</a></h2>


<ul>
	<li><a name="Adicionar"> Adicionar um planeta (com nome, clima e terreno)</a></li><br/>
Método HTTP: POST<br/>
URI Utilizada: http://localhost:8080/api/planetas<br/>
Body: { "nome": "Alderaan", "clima": "temperate", "terreno": "grasslands, mountains" }<br/>
Status da execução esperado: 201 Created<br/>

<img src="/docs/adicionar_planeta.PNG" alt="Teste" style="max-width:100%;">
<br/>
<br/>
<br/>

<li><a name="Listar">Listar planetas</a></li><br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas<br/>
	Status da execução esperado: 200 OK<br/>
	

<img src="/docs/listar-planetas.PNG" alt="Teste" style="max-width:100%;">
<br/>
<br/>
<br/>

<li><a name="BuscarNome">Buscar por nome</a></li><br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas/nome/Yavin IV<br/>
	Status da execução esperado: 200 OK<br/>
	
<img src="/docs/buscar-nome.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

<li><a name="BuscarID">Buscar por ID</a></li><br/>
        Método HTTP: GET<br/>
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa4939d50481fe4c0120e<br/>
	Status da execução esperado: 200 OK<br/>
	
<img src="/docs/bucar-id.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

<li><a name="Remover">Remover planeta</a></li><br/>
        Método HTTP: DELETE<br/>
	URI Utilizada: http://localhost:8080/api/planetas/5c9aa3979d50481fe4c0120c<br/>
	Status da execução esperado: 204 No Content<br/>
	
<img src="/docs/remover-planeta.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

<li><a name="AdicionarSemNome">Adicionar um planeta sem Nome (com nome, clima e terreno)</a></li><br/>
Método HTTP: POST<br/>
URI Utilizada: http://localhost:8080/api/planetas<br/>
Body: { "nome": "", "clima": "temperate", "terreno": "grasslands, mountains" }<br/>
Status da execução esperado: 400 Bad Request<br/>
Mensagem do erro: Nome não pode ser vazio<br/>

<img src="/docs/inserir_sem_nome.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

<li><a name="AdicionarSemClima">Adicionar um planeta sem Clima (com nome, clima e terreno)</a></li><br/>
Método HTTP: POST<br/>
URI Utilizada: http://localhost:8080/api/planetas<br/>
Body: { "nome": "Alderaan", "clima": "", "terreno": "grasslands, mountains" }<br/>
Status da execução esperado: 400 Bad Request<br/>
Mensagem do erro: Clima não pode ser vazio<br/>

<img src="/docs/inserir_sem_clima.PNG" alt="Teste" style="max-width:100%;">
<br/>	
<br/>	
<br/>	

<li><a name="AdicionarSemTerreno">Adicionar um planeta sem Terreno (com nome, clima e terreno)</a></li><br/>
Método HTTP: POST<br/>
URI Utilizada: http://localhost:8080/api/planetas<br/>
Body: { "nome": "Alderaan", "clima": "temperate", "terreno": "" }<br/>
Status da execução esperado: 400 Bad Request<br/>
Mensagem do erro: Terreno não pode ser vazio<br/>

<img src="/docs/inserir_sem_terreno.PNG" alt="Teste" style="max-width:100%;">
</ul>

<h3>Desenvolvido por: Cleomir de Sousa Cardoso Junior</h3>