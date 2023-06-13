package br.com.byteatrworks.repositories;

import br.com.byteatrworks.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
