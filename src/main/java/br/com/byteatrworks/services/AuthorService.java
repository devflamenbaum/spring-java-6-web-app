package br.com.byteatrworks.services;

import br.com.byteatrworks.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
