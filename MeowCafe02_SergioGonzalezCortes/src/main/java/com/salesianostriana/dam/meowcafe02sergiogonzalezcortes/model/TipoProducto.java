package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

public enum TipoProducto {

	BEBIDA("BEBIDA"),
	COMIDA("BEBIDA");
	
	private String tipo;
	
	private TipoProducto (String tipo) {
		
		this.tipo = tipo;
	}
	
	public String getTipo () {
		
		return tipo;
	}
	
	public void setTipo(String tipo) {
		
		this.tipo = tipo;
	}
	
}
