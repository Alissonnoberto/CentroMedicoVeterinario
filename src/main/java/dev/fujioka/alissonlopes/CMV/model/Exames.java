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
@Table(name = "TB_EXAME")
public class Exames {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome do exame é obrigatório")
	@Column(length = 15, name = "Nome_exame")
	private String exame;


	@Column(name = "Valor_exame")
	private double valor;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(length = 8, name = "Data_exame")
	private LocalDate dataExame;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataExame() {
		return dataExame;
	}

	public void setDataExame(LocalDate dataExame) {
		this.dataExame = dataExame;
	}

	
}
