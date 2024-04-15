package com.salesianostriana.dam.meowcafe;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class Anunsios {

	private final List<String> listaAnuncios;
	
	public Anunsios (List<String> listaAnuncios) {
		
		this.listaAnuncios = Arrays.asList(new String[] {"https://www.inboundcycle.com/hs-fs/hubfs/anuncios%20publicitarios%20recordatorios.jpg?width=480&height=600&name=anuncios%20publicitarios%20recordatorios.jpg",
				"https://concepto.de/wp-content/uploads/2020/12/Ejemplo-de-anuncios-publicitarios-agua.jpg",
				"https://s2.ppllstatics.com/elcomercio/www/multimedia/202203/07/media/cortadas/messi-lays-kPrD-U160122932914299E-1248x770@El%20Comercio.jpg", 
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL64Ex2FLcjzzjSJtyMyQYBEKhbEr1iV_buDO5opyzoA&s" });

	}
	
	
	public List<String> getListaAnuncios () {
		
		return listaAnuncios;
	}

}
