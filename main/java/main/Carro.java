package main;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String modelo;

	@ManyToOne(optional = false)
	private Marca marca;

	@ManyToMany
	@JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "carro_id"), inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;

	public Carro() {
	}

	public Carro(String modelo, Marca marca, List<Acessorio> acessorios) {
		this.modelo = modelo;
		this.marca = marca;
		this.acessorios = acessorios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
}
