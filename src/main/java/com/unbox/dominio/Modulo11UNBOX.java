package com.unbox.dominio;

public class Modulo11UNBOX extends Modulo11 {

	public Modulo11UNBOX(long numero) {
		super(numero);
	}

	public Modulo11UNBOX(String numero) {
		super(numero);
	}

	/*
	 * @see br.gov.caixa.sispl.dominio.Modulo#getDV()
	 */
	public int getDV() {
		int dv = super.getDV();
		if (dv > 9)
			return 0;
		return dv;

	}
}