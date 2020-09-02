package com.unbox.dominio;

import java.util.HashSet;
import java.util.Set;

import com.unbox.exceptions.RegraNegocioException;

public class CPF {

	private String cpf;

	private static final Set cpfInvalidos = new HashSet();

	static {
		cpfInvalidos.add("00000000000");
		cpfInvalidos.add("11111111111");
		cpfInvalidos.add("22222222222");
		cpfInvalidos.add("33333333333");
		cpfInvalidos.add("44444444444");
		cpfInvalidos.add("55555555555");
		cpfInvalidos.add("66666666666");
		cpfInvalidos.add("77777777777");
		cpfInvalidos.add("88888888888");
		cpfInvalidos.add("99999999999");
		cpfInvalidos.add("00000000191");
		cpfInvalidos.add("00000000686");
		cpfInvalidos.add("99999994001");
		cpfInvalidos.add("00000000686");
	}

	/**
	 * Construtor que deve receber um CPF válido, e apenas numérico.
	 * <p>
	 * Exemplo: O CPF 10000098744 <strong>não</strong> deve ser conter
	 * <strong>dígitos separadores</strong>: 100.000.987-44 ou 100000987-44
	 * </p>
	 * 
	 * @param cpf
	 */
	public CPF(String cpf) throws RegraNegocioException {
		validateSetCPF(cpf);
	}

	/**
	 * Constrói um objeto CPF sem definir o número de CPF em si.
	 */
	public CPF() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @see CPF#CPF(String)
	 */
	public void validateSetCPF(String cpf) throws RegraNegocioException {
		validateCPF(cpf);
		setCpf(cpf);
	}

	public static void validateCPF(String cpf) throws RegraNegocioException {
		validateCpfNull(cpf);
		validateTamanho(cpf);
		validateValores(cpf);
		validateDV(cpf);
	}

	/**
	 * {@link CPF} não pode ser null
	 * 
	 * @throws RegraNegocioException
	 */
	private static void validateCpfNull(String cpf) throws RegraNegocioException {
		if (cpf == null)
			throw new RegraNegocioException("ERRO CPF - CPF NULO");
	}

	/**
	 * @see Modulo11CPF
	 */
	private static void validateDV(String cpf) throws RegraNegocioException {
		String cpfSemDV = cpf.substring(0, 9);
		String dvCPF = cpf.substring(9);

		String primeiroDV = String.valueOf(calculaPrimeiroDV(cpfSemDV));
		String segundoDV = String.valueOf(calculaSegundoDV(cpfSemDV + primeiroDV));

		if (!dvCPF.equals(primeiroDV + segundoDV))
			throw new RegraNegocioException("ERRO CPF - DIGITO INVÁLIDO");
	}

	/**
	 * Valida se o CPF não está na lista de CPFs inválidos
	 */
	private static void validateValores(String cpf) throws RegraNegocioException {
		if (cpfInvalidos.contains(cpf)) {
			throw new RegraNegocioException("ERRO CPF - CPF VALORES INVÁLIDOS");
		}
	}

	/**
	 * Valida se o CPF possui tamanho igual a 11
	 */
	private static void validateTamanho(String cpf) throws RegraNegocioException {
		if (cpf.length() != 11) {
			throw new RegraNegocioException("ERRO CPF - CPF TAMANHO INVÁLIDO");
		}
	}

	/**
	 * @see Modulo11CPF
	 */
	private static int calculaPrimeiroDV(String cpf) {
		return new Modulo11CPF(cpf, 10).getDV();
	}

	/**
	 * @see Modulo11CPF
	 */
	private static int calculaSegundoDV(String cpf) {
		return new Modulo11CPF(cpf, 11).getDV();
	}
}
