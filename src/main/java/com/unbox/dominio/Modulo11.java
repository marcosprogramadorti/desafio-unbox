package com.unbox.dominio;

public abstract class Modulo11 extends Modulo {

	public Modulo11(long numero) {
		super(numero);
	}

	public Modulo11(String numero) {
		super(numero);
	}

	/*
	 * 
	 * @see br.gov.caixa.sispl.dominio.Modulo#calculaModulo()
	 */
	protected int calculaDV(int[] numeroArray) {
		int coeficiente = 2;
		int somatorio = 0;

		for (int i = numeroArray.length - 1; i >= 0; i--) {
			int numeroArrayMultiplicado = numeroArray[i] * coeficiente;
			somatorio += numeroArrayMultiplicado;

			coeficiente++;
			if (coeficiente > 9)
				coeficiente = 2;
		}

		return 11 - (somatorio % 11);
	}

}
