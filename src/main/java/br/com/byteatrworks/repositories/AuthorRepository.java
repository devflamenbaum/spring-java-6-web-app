package br.com.byteatrworks.repositories;

import br.com.byteatrworks.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
