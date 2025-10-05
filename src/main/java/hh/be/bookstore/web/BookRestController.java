package hh.be.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {
    private BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // RESTful service to get all books
    // Java-kielinen Book-luokan oliolista muunnetaan JSON-kirjalistaksi ja
    // lähetetään web-selaimelle vastauksena
    @GetMapping("/api/booklist")
    public @ResponseBody List<Book> findAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // RESTful service to get book by id
    @GetMapping("/api/booklist/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    // RESTful service to save new book
    @PostMapping("/api/booklist")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }

}
