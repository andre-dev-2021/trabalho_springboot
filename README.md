# Trabalho Spring Boot

API REST para gerenciamento de alunos, cursos e professores.

## Funcionalidades

- Cadastrar alunos, cursos e professores.
- Listar todos os registros de cada recurso.
- Buscar um aluno, curso ou professor pelo ID.
- Filtrar alunos por curso.
- Filtrar cursos por professor.
- Validar os dados recebidos nas requisições.
- Persistir os dados com Spring Data JPA e banco H2.
- Retornar respostas de erro para recursos inexistentes ou referências inválidas.

## Regras de negócio

- Todo aluno deve estar vinculado a um curso existente.
- Todo curso deve estar vinculado a um professor existente.
- Os nomes de alunos, cursos e professores são obrigatórios e devem ter entre 3 e 100 caracteres.
- O e-mail de alunos e professores é obrigatório, deve ter formato válido e não pode se repetir para alunos.
- O departamento do professor é opcional, mas, quando informado, deve ter entre 3 e 50 caracteres.
- Consultas por ID retornam `404 Not Found` quando o recurso não existe.
- Tentativas de usar um curso ou professor inexistente como referência retornam `422 Unprocessable Content`.
- Dados de entrada inválidos retornam `400 Bad Request` com a lista de erros de validação.

## Tecnologias

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven

## Endpoints principais

| Método | Endpoint | Função |
| --- | --- | --- |
| GET | `/aluno` | Lista os alunos |
| GET | `/aluno/{id}` | Busca um aluno |
| POST | `/aluno` | Cadastra um aluno |
| GET | `/aluno?idCurso={id}` | Lista alunos de um curso |
| GET | `/curso` | Lista os cursos |
| GET | `/curso/{id}` | Busca um curso |
| POST | `/curso` | Cadastra um curso |
| GET | `/curso?idProfessor={id}` | Lista cursos de um professor |
| GET | `/professor` | Lista os professores |
| GET | `/professor/{id}` | Busca um professor |
| POST | `/professor` | Cadastra um professor |

## Como executar

Na pasta `trabalho_springboot`, execute:

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.