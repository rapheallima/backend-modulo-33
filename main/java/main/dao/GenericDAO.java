package main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericDAO<T> implements GenericDAOInterface<T> {
	private final EntityManager entityManager;
	private final Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		this.entityManager = emf.createEntityManager();
		this.entityClass = entityClass;
	}

	@Override
	public void cadastrar(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	@Override
	public T buscar(Long id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public List<T> listarTodos() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public void alterar(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	@Override
	public void excluir(Long id) {
		T entity = buscar(id);
		if (entity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		}
	}

	public void fechar() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
