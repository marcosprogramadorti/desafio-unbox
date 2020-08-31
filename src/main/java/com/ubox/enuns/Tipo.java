package com.ubox.enuns;

public enum Tipo {
	LONG_PRIMITIVO("long"),
	LONG("Long"),
	INT_PRIMITIVO("int"),
	FLOAT_PRIMITIVO("float"),
	DOUBLE_PRIMITIVO("double"),
	STRING("String");
	
	
	private final String tipo;
	
	Tipo(final String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	

	
	
}
