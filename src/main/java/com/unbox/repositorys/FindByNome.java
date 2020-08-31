package com.unbox.repositorys;

import java.util.List;

public interface FindByNome<T> {
	List<T> findByNomeContainingIgnoreCase( String nome);
}
