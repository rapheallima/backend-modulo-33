# Módulo 33: Testes da DAO Genérica

Este repositório contém a implementação e os testes da classe `GenericDAO`, que fornece operações básicas de CRUD (criar, ler, atualizar e excluir) para as entidades `Marca`, `Carro` e `Acessorio`.

## Funcionalidade

A classe `GenericDAO` usa JPA e o `EntityManager` para interagir com o banco de dados. Ela inclui os seguintes métodos:

- `cadastrar(T entity)`: Para salvar uma nova entidade.
- `buscar(Long id)`: Para buscar uma entidade pelo seu ID.
- `listarTodos()`: Para listar todas as entidades da tabela.
- `alterar(T entity)`: Para atualizar uma entidade existente.
- `excluir(Long id)`: Para excluir uma entidade pelo seu ID.

## Testes

A classe de testes `GenericDAOTest` verifica a funcionalidade da DAO para a entidade `Marca` e inclui testes para:

- Cadastro e consulta de uma entidade.
- Listagem de todas as entidades.
- Atualização de uma entidade.
- Exclusão de uma entidade.

## Dependências

- JUnit 4 para testes.
- Hibernate e JPA para persistência no banco de dados.
