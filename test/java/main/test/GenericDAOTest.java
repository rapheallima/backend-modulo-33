package main.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.Acessorio;
import main.Carro;
import main.Marca;
import main.dao.GenericDAO;

public class GenericDAOTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static GenericDAO<Marca> marcaDAO;
	private static GenericDAO<Carro> carroDAO;
	private static GenericDAO<Acessorio> acessorioDAO;

	@BeforeClass
	public static void setup() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");

		em = emf.createEntityManager();
		marcaDAO = new GenericDAO<>(Marca.class);
		carroDAO = new GenericDAO<>(Carro.class);
		acessorioDAO = new GenericDAO<>(Acessorio.class);
	}

	@Test
	public void testCadastrarEConsultar() {
		Marca marca = new Marca("Toyota");
		marcaDAO.cadastrar(marca);

		Marca encontrada = marcaDAO.buscar(marca.getId());
		assertNotNull(encontrada);
		assertEquals("Toyota", encontrada.getNome());
	}

	@Test
	public void testListarTodos() {
		List<Marca> marcas = marcaDAO.listarTodos();
		assertFalse(marcas.isEmpty());
	}

	@Test
	public void testAlterar() {
		Marca marca = new Marca("Ford");
		marcaDAO.cadastrar(marca);

		marca.setNome("Ford Atualizado");
		marcaDAO.alterar(marca);

		Marca atualizada = marcaDAO.buscar(marca.getId());
		assertEquals("Ford Atualizado", atualizada.getNome());
	}

	@Test
	public void testExcluir() {
		Marca marca = new Marca("Chevrolet");
		marcaDAO.cadastrar(marca);

		marcaDAO.excluir(marca.getId());
		assertNull(marcaDAO.buscar(marca.getId()));
	}

	@AfterClass
	public static void tearDown() {
		em.close();
		emf.close();
	}
}
