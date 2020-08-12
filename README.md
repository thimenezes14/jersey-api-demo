# jersey-api-demo
Atividade de ADI: API REST com CRUD básico com Jersey, Grizzle e Hibernate/JPA

# Sobre o projeto
Este projeto visa demonstrar a implementação básica de uma API REST (JAX-RS) em Java utilizando o Jersey com o framework Grizzle e persistência de dados com JPA implementado com Hibernate. O SGBD utilizado é o PostgreSQL na versão 12.

# Configurando e Rodando

   * Certifique-se de que você tem o Java 11 instalado.
   * Certifique-se de que você tem o PostgreSQL 12 instalado.
   * Importe o projeto para o contexto da sua IDE (Eclipse, IntelliJ, NetBeans etc)
   * Atualize o projeto pelo Maven para que as dependências sejam instaladas
   * Rode o projeto. A porta 8080 será utilizada (você pode alterá-la caso necessário)
   
# Utilizando a API
Este projeto implementa um CRUD básico de cadastro de usuários. Cada usuário contém um UUID (gerado automaticamente pelo SGBD), nome, email e telefone.

```
public class User {
  private UUID id;
  private String name;
  private String email;
  private String telephone;
  
  //default getters and setters
}
```
O envio de um recurso para criação de um novo usuário é feito pelo body da requisição, cujo objeto deve conter propriedades com nomes iguais aos atributos da classe User.


| Endpoint                | Método          | Parâmetro(s) de Entrada             | Resposta (OK)   | Descrição
| :---------------------  |:---------------:| :----------------------------------:| :--------------:| :---------------:
| /api/users/get          | GET             | -                                   | Array[User]     | Lista todos os usuários
| /api/users/find         | GET             | term (query)                        | Array[User]     | Pesquisa usuário(s) por nome
| /api/users/{id}         | GET             | id (param)                          | Objeto[User]    | Pesquisa usuário por id
| /api/users/save         | POST            | Objeto[User] (body)                 | Objeto[User]    | Cria novo usuário
| /api/users/update/{id}  | PATCH           | id (param), Objeto[User] (body)     | Objeto[User]    | Atualiza dados de usuário
| /api/users/remove/{id}  | DELETE          | id (param)                          | void            | Remove um usuário

# Os métodos HTTP
Para seguir o padrão REST (Representational State Transfer), foram adotados verbos HTTP pertinentes a cada operação com os recursos da API.

   * O método GET foi empregado em operações de consulta e seleção de recurso (ex.: busca de informações de usuário)
   * O método POST foi empregado na operação de envio de dados para criação de novo recurso (cadastro de usuário)
   * O método PATCH foi empregado na operação de atualização parcial ou total de um recurso (optou-se por PATCH em vez de PUT devido ao fato de que nem sempre o recurso será atualizado por inteiro, como o método PUT sugere)
   * O método DELETE foi empregado na operação de exclusão de um recurso (remoção de usuário)
   
    * Autor: Thiago Santos Menezes - IFSP Campus Guarulhos - CST ADS
