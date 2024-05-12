package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

public enum TipoUsuario {

	ADMIN("ADMIN"),
	CLIENTE("CLIENTE");
	
	private String valor;
	
	
	private TipoUsuario (String valor) {
		
		this.valor = valor;
	}
	
	public String getValor () {
		
		return valor;
	}
	
	public void setValor(String valor) {
		
		this.valor = valor;
	}
}
