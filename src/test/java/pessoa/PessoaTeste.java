package pessoa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.unbox.entidades.Pessoa;
import com.unbox.repositorys.IPessoa;

public class PessoaTeste {

	@Autowired
	IPessoa pessoaRepository;

	@Test
	public void PesquisarPorNome() {
		Pageable primeiraPaginaComDoisElementos = PageRequest.of(0, 2);
		Page<Pessoa> results = pessoaRepository.findByNomeContainingIgnoreCase("Marcos",
				primeiraPaginaComDoisElementos);
		assertTrue(results.getSize() > 0);
	}

}
