package br.com.byteatrworks.services;

import br.com.byteatrworks.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
