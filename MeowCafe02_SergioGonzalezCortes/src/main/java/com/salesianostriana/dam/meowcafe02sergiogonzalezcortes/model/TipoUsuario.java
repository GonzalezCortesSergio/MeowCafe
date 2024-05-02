package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

public enum TipoUsuario {

	ADMIN("ADMIN"),
	CLIENTE("CLIENTE");
	
	private String tipo;
	
	
	private TipoUsuario (String tipo) {
		
		this.tipo = tipo;
	}
	
	public String getTipo () {
		
		return tipo;
	}
	
	public void setTipo(String tipo) {
		
		this.tipo = tipo;
	}
}
