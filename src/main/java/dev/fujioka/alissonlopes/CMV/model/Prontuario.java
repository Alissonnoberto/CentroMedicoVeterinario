package dev.fujioka.alissonlopes.CMV.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author alisson
 *
 */

@Entity
@Table(name = "TB_PRONTUARIO")
public class Prontuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotBlank(message = "Descrição da consulta é obrigatório")
	@Column(length = 100, name = "Descricao_atendimento")
	private String descricao;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(length = 15)
	private LocalDate dataAtendimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(LocalDate dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

}