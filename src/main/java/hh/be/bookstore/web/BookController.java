package hh.be.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;
import hh.be.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    private BookRepository bRepository;

    @SuppressWarnings("unused")
    private CategoryRepository cRepository;

    public BookController(BookRepository bRepository, CategoryRepository cRepository) {
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    }

    @GetMapping("/index")
    public String getBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", new Book());
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String getBookList(@ModelAttribute Book book, Model model) {
        model.addAttribute("booklist", bRepository.findAll());
        return "booklist"; // booklist.html
    }

    @GetMapping("/addbook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book) {
        bRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{isbn}")
    public String editBook(@PathVariable Long isbn, Model model) {
        model.addAttribute("book", bRepository.findById(isbn).orElse(null));
        return "editBook";
    }

    @GetMapping("/deletebook/{isbn}")
    public String deleteBook(@PathVariable Long isbn, Model model) {
        bRepository.deleteById(isbn);
        return "redirect:/booklist";
    }

}
