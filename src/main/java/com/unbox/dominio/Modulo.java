package com.unbox.dominio;

public abstract class Modulo {

	protected String numero;

	/**
	 * Esse construtor não deve ser chamado
	 */
	public Modulo() {
	}

	public Modulo(long numero) {
		this.numero = String.valueOf(numero);
	}

	/**
	 * O dígito verificador deve conter apenas inteiros.
	 * 
	 * @param numero número a ser calculado
	 */
	public Modulo(String numero) {
		if (numero == null)
			throw new IllegalArgumentException("O número a ser calculado o módulo não pode ser null");

		this.numero = numero;
	}

	/**
	 * Calcula o dígito verificador da sequência de números.
	 * 
	 * @param numero
	 * @return Digito verificador
	 */
	public int getDV() {

		return calculaDV(toIntArray(numero));
	}

	/**
	 * Converte um long para um array de inteiros.
	 * 
	 * @param numero Numero a ser convertido em array de números
	 * @return o array de números
	 */
	private int[] toIntArray(String numero) {
		int[] numeroArray = new int[numero.length()];
		for (int i = 0; i < numero.length(); i++) {
			numeroArray[i] = Character.getNumericValue(numero.charAt(i));
		}
		return numeroArray;
	}

	/**
	 * Faz a somatória da sequência de números multiplicada pelo coeficiente do
	 * algoritmo e calcula o módulo.
	 * 
	 * @return o módulo calculado
	 */
	protected abstract int calculaDV(int[] numeroArray);

	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Numero [" + numero + "]\nDV [" + getDV() + "]";
	}
}