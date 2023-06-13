package br.com.byteatrworks.repositories;

import br.com.byteatrworks.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
