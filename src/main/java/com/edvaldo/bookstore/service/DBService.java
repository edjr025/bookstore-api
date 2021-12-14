package com.edvaldo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edvaldo.bookstore.domain.Categoria;
import com.edvaldo.bookstore.domain.Livro;
import com.edvaldo.bookstore.repositories.CategoriaRepository;
import com.edvaldo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

		public void instaciaBaseDeDados() {
			Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
			Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Cientifico");
			Categoria cat3 = new Categoria(null, "Biografia", "Biografico");
			
			Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsun", cat1);
			Livro l2 = new Livro(null, "Engenharia de Software", "louis V", "Lorem", cat1);
			Livro l3 = new Livro(null, "The Time Machine", "H G Wells", "Lorem", cat2);
			Livro l4 = new Livro(null, "The war of the  worlds", "Henri G", "Lorem ipsum", cat2);
			Livro l5 = new Livro(null, "Bill Gates primary", "jack van Horf", "Lorem bill", cat3);
			Livro l6 = new Livro(null, "Stive Job Legend", "Black Piece", "Lorem job", cat3);
			
			
			cat1.getLivros().addAll(Arrays.asList(l1,l2));
			cat2.getLivros().addAll(Arrays.asList(l3,l4));
			cat3.getLivros().addAll(Arrays.asList(l5,l6));
			
			this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
			this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
		}
}
