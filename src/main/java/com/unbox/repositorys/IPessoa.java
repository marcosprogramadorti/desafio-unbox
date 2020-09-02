package com.unbox.repositorys;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unbox.entidades.Pessoa;

@Repository
public interface IPessoa extends PagingAndSortingRepository<Pessoa, Long>{
	Page<Pessoa> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
	Optional<Pessoa> findByCpf(String cpf);
	
}
		