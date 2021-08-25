
<!-- SOBRE O PROJETO -->
## SOBRE O PROJETO

Crud utilizando Spring Boot e JPA, para aprendizado. 

Tecnologias utilizadas:
* Java
* JPA
* SpringBoot
* Hibernate
* Oracle Database

<!-- GETTING STARTED -->
## Instalação

### Pré requisitos

* Insomnia/Postman ( Para testar os endpoints ) 
  
* Alguma IDE que rode Java  como Eclipse, Intellij... 
  
* Docker  


### Instalação

1. Clone o repo
   ```sh
   git clone https://github.com/Raeski/Crud-Client
   ```
2. Suba a imagem do Oracle com o comando 
  ```sh
      docker pull store/oracle/database-enterprise:12.2.0.1
  ```
3. Dentro de application.properties precisa ser configurado novamente o schema que será utilizado. 

3. Execute o arquivo ClientApplication em uma IDE

4. No insomnia/postman teste os endpoins no localhost:8080

```
    Exemplo de JSON :
    {
    "name":"teste",
	  "cpf": "10110110111",
	  "email": "teste@hotmail.com",
	  "nascimento": "1629896462000" (TIMESTAMP)
    }
 ```

   ```JS
   POST /client - Para criar um cliente
   
   POST /client/replace - Para atualizar um cliente
   
   GET /client/{id} - Retorna o cliente que foi passado o id
   
   DELETE /client/{id} - Deleta o cliente que foi passado o id
   
   ```

