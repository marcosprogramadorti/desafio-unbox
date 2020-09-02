package pessoa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unbox.Main;
import com.unbox.entidades.Pessoa;
import com.unbox.servicos.Servico;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = Main.class)
public class PessoaValidatorRestApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Servico servico;
    
    @Test
    void case1Salvar() throws Exception {
    	//LocalDateTime dtNascimento = LocalDateTime.of(2020, 2, 9,0,0);
    	String nascimento = "January 1, 1978";
    	DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
    	Date date = format.parse(nascimento);
    	Pessoa p = new Pessoa();
    	p.setCpf("79414314083");
    	p.setDataNascimento(date);
    	p.setNome("Marcos Ferreira");
    	
    	mockMvc.perform(post("http://localhost:8080/unbox/salvar")
    	        .contentType("application/json")
    	        .content(objectMapper.writeValueAsString(p)))
    	        .andExpect(status().isOk());
    	
    	Pessoa pessoaTeste = servico.buscarPorCPF("79414314083");

        Assertions.assertEquals(pessoaTeste.getNome(), "Marcos Ferreira");
        
    	
    }
}
