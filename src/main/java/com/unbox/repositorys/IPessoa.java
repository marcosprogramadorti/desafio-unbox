package com.unbox.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unbox.entidades.Pessoa;

@Repository
public interface IPessoa extends JpaRepository<Pessoa, Long>, FindByNome<Pessoa>, IServicoGenerico{
	
}
		