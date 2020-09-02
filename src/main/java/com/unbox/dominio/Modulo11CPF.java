package com.unbox.dominio;

public class Modulo11CPF extends Modulo11UNBOX {

	private int coeficienteInicial;

	public Modulo11CPF(String cpf, int coeficienteInicial) {
		super(cpf);
		this.coeficienteInicial = coeficienteInicial;
	}

	/*
	 * @see br.gov.caixa.sispl.dominio.Modulo#calculaModulo()
	 */
	protected int calculaDV(int[] numeroArray) {
		int coeficiente = coeficienteInicial;
		int somatorio = 0;

		for (int i = 0; i < numeroArray.length; i++) {
			int numeroArrayMultiplicado = numeroArray[i] * coeficiente;
			somatorio += numeroArrayMultiplicado;

			coeficiente--;
			if (coeficiente < 2)
				coeficiente = coeficienteInicial;
		}

		return 11 - (somatorio % 11);
	}
}
