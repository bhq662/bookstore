package hh.be.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;
import hh.be.bookstore.domain.Category;
import hh.be.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			System.out.println("Save a few books");
			Book b1 = bRepository
					.save(new Book("Crime and punishment", "Fyodor Dostoyevsky", 1866, 9781840224306L, 9.99f));
			System.out
					.println("Book id= " + b1.getIsbn() + ", title= " + b1.getTitle() + ", author= " + b1.getAuthor());
			Book b2 = bRepository.save(new Book("Foe", "Iain Reid", 2019, 9781471177989L, 14.99f));
			System.out
					.println("Book id= " + b2.getIsbn() + ", title= " + b2.getTitle() + ", author= " + b2.getAuthor());
			Book b3 = bRepository.save(new Book("1Q84", "Haruki Murakami", 2012, 9780099578079L, 22.99f));
			System.out
					.println("Book id= " + b3.getIsbn() + ", title= " + b3.getTitle() + ", author= " + b3.getAuthor());

			System.out.println("Save a few categories");
			Category c1 = cRepository.save(new Category(null, "Dystopian"));
			System.out.println("Category [id=" + c1.getcId() + ", name=" + c1.getcName() + "]");
			Category c2 = cRepository.save(new Category(null, "Horror"));
			System.out.println("Category [id=" + c2.getcId() + ", name=" + c2.getcName() + "]");
			Category c3 = cRepository.save(new Category(null, "Romance"));
			System.out.println("Category [id=" + c3.getcId() + ", name=" + c3.getcName() + "]");
			Category c4 = cRepository.save(new Category(null, "Fiction"));
			System.out.println("Category [id=" + c4.getcId() + ", name=" + c4.getcName() + "]");
			Category c5 = cRepository.save(new Category(null, "Classics"));
			System.out.println("Category [id=" + c5.getcId() + ", name=" + c5.getcName() + "]");
		};
	}
}
