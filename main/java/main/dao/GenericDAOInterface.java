package main.dao;

import java.util.List;

public interface GenericDAOInterface<T> {
	void cadastrar(T entity);

	T buscar(Long id);

	List<T> listarTodos();

	void alterar(T entity);

	void excluir(Long id);
}
