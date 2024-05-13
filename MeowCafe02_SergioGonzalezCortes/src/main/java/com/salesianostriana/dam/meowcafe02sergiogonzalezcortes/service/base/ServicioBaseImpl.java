package com.salesianostriana.dam.meowcafe02sergiogonzalezcortes.service.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ServicioBaseImpl <T, ID, R extends JpaRepository<T, ID>> implements ServicioBase<T, ID>{

	@Autowired
	protected R repository;
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public T edit(T t) {
		// TODO Auto-generated method stub
		return repository.save(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
	
		repository.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		
		repository.deleteById(id);
	}

}
