package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.model;

import java.util.ArrayList;
import java.util.List;

import com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.ServicioProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

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
	
	private double precioCombo;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (
			name = "producto_combo",
			joinColumns = @JoinColumn(name = "combo_id"),
			inverseJoinColumns = @JoinColumn(name = "producto_id")
	)
	private List<Producto> producto = new ArrayList<Producto>();



} 
