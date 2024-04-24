package com.salesianostriana.dam.meowcafe.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.meowcafe.model.Gato;

@Service
public class ServicioGato {

	
	public List<Gato> getLista() {
		
		return Arrays.asList(
				new Gato (1, "Ministro", LocalDateTime.now(), false, true, "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTjTyTegPI3QWHIbeJsS3A9TkqCbbd55ZNL4qGMDKR0AiE-1oaIYX9YtU8PYKBloZRUG6U"),
				new Gato (2, "Michi", LocalDateTime.now(), true, false, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/BlacktabbyMaine_Coon.JPG/1200px-BlacktabbyMaine_Coon.JPG"),
				new Gato (3, "Pepelui", LocalDateTime.now(), false, true, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSiFK4XbkpK-B1xakqD-1VkzZFuM25Wop9lm09QPwnNz8ARAbP8")
				);
	}
}
