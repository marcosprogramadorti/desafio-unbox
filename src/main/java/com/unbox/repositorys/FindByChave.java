package com.unbox.repositorys;

import java.util.List;

public interface FindByChave<T> {
	List<T> findByChaveContainingIgnoreCase( String nome);
}
