package com.unbox.dto;

import java.time.LocalDateTime;

public class PessoaTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private LocalDateTime dtNascimento;
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
	public LocalDateTime getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
	
	
	
	
}
