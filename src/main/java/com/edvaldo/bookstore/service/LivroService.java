package com.edvaldo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edvaldo.bookstore.domain.Livro;
import com.edvaldo.bookstore.repositories.LivroRepository;
import com.edvaldo.bookstore.service.exceptions.ObjectNotFoundException;



@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id:" + id + ", Tipo: " + Livro.class.getName()));

	}
}
