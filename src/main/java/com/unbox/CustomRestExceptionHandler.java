package com.unbox;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String ERRO_AO_GRAVAR_DADOS_DE_PESSOA = "Erro ao gravar dados de pessoa.";

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ApiErrorUnbox apiErrorUnbox = new ApiErrorUnbox();
		if (status.isError()) {
			apiErrorUnbox.setMensagem(ERRO_AO_GRAVAR_DADOS_DE_PESSOA);
			return super.handleExceptionInternal(ex, apiErrorUnbox, headers, status, request);
		}
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

}
