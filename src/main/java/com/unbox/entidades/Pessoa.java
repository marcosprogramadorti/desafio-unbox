package com.unbox.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "pessoa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 80)
	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@Column(nullable = false, length = 11)
	@NotBlank(message = "cpf é obrigatório")
	private String cpf;

	@Column(nullable = false, unique = true)
	private Date dataNascimento;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	

}
