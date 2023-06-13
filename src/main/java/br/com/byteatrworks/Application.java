package br.com.byteatrworks;

import br.com.byteatrworks.domain.Author;
import br.com.byteatrworks.domain.Book;
import br.com.byteatrworks.domain.Publisher;
import br.com.byteatrworks.repositories.AuthorRepository;
import br.com.byteatrworks.repositories.BookRepository;
import br.com.byteatrworks.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PublisherRepository publisherRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Author eric = new Author();

			eric.setFirstName("Eric");
			eric.setLastName("Evans");

			Book ddd = new Book();
			ddd.setTitle("Domain Driven Design");
			ddd.setIsbn("123456");

			Author ericSaved = authorRepository.save(eric);
			Book dddSaved = bookRepository.save(ddd);

			Author rod = new Author();
			rod.setFirstName("Rod");
			rod.setLastName("Johnson");

			Book noEJB = new Book();
			noEJB.setTitle("J2EE Development without EJB");
			noEJB.setIsbn("54757585");

			Author rodSaved = authorRepository.save(rod);
			Book noEJBSaved = bookRepository.save(noEJB);

			Publisher publisher = new Publisher();
			publisher.setPublisherName("My Publisher");
			publisher.setAddress("123 Main");
			Publisher savedPublisher = publisherRepository.save(publisher);

			dddSaved.setPublisher(savedPublisher);
			noEJBSaved.setPublisher(savedPublisher);

			dddSaved.getAuthors().add(ericSaved);
			noEJBSaved.getAuthors().add(rodSaved);
			ericSaved.getBooks().add(dddSaved);
			rodSaved.getBooks().add(noEJBSaved);

			authorRepository.save(ericSaved);
			authorRepository.save(rodSaved);
			bookRepository.save(dddSaved);
			bookRepository.save(noEJBSaved);

			System.out.println("In Bootstrap...");
			System.out.println("Author Count: " + authorRepository.count());
			System.out.println("Book Count: " + bookRepository.count());
			System.out.println("Publisher Count: " + publisherRepository.count());
		};
	}

}
