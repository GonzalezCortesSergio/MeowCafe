package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Combo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombreCombo;
	
	private boolean esOferta;
	
	private float precioCombo;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="combo",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	
	//HELPER
	
	public void agregarProducto(Producto producto) {
		
		producto.setCombo(this);
		this.productos.add(producto);
	}
	
	public void eliminarProducto (Producto producto) {
		
		this.productos.remove(producto);
		producto.setCombo(null);
	}
	
	
	public void calcularPrecioCombo () {
		precioCombo = 0;
		for (Producto producto : productos) {
			
			setPrecioCombo(precioCombo + producto.getPrecio());
			
		}
	}

} 
