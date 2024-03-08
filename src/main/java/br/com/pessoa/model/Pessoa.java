package br.com.pessoa.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa extends RepresentationModel<Pessoa> implements Serializable {
	
	private static final long serialVersionUID = -394644876691526116L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPessoa;
	private String nome;
	private int idade;
	
	public Pessoa(Long idPessoa, String nome, int idade) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idPessoa, idade, nome);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idPessoa, other.idPessoa) && idade == other.idade && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	
	
	
}
