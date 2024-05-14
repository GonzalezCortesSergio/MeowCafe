package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

public enum TipoProducto {

	BEBIDA("BEBIDA"),
	COMIDA("COMIDA");
	
	private String valor;
	
	private TipoProducto (String valor) {
		
		this.valor = valor;
	}
	
	public String getValor () {
		
		return valor;
	}
	
	public void setTipo(String valor) {
		
		this.valor = valor;
	}
	
}
