package hh.be.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = repository
					.save(new Book("Crime and punishment", "Fyodor Dostoyevsky", 1866L, 9781840224306L, 9.99f));
			System.out
					.println("Book id= " + b1.getIsbn() + ", title= " + b1.getTitle() + ", author= " + b1.getAuthor());
			Book b2 = repository.save(new Book("Foe", "Iain Reid", 2019L, 9781471177989L, 14.99f));
			System.out
					.println("Book id= " + b2.getIsbn() + ", title= " + b2.getTitle() + ", author= " + b2.getAuthor());
			Book b3 = repository.save(new Book("1Q84", "Haruki Murakami", 2012L, 9780099578079L, 22.99f));
			System.out
					.println("Book id= " + b3.getIsbn() + ", title= " + b3.getTitle() + ", author= " + b3.getAuthor());
		};
	}

}
