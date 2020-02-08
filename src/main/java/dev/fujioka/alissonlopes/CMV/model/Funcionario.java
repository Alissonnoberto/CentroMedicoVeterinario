package dev.fujioka.alissonlopes.CMV.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author alisson
 *
 */

@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome do proprietario é obrigatório")
	@Column(length = 15, name = "Nome_funcionario")
	private String nome;

	@NotBlank(message = "CPF é obrigatório")
	private String cpf;

	@Column(name = "Idade_funcionario")
	private int idade;
	
	@NotBlank(message = "Nome do funcionário é obrigatório")
	@Column(length = 15, name = "Cargo_funcionario")
	private String funcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	

}
