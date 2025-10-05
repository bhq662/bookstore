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
        model.addAttribute("categorylist", cRepository.findAll());
        return "booklist"; // booklist.html
    }

    @GetMapping("/addbook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categorylist", cRepository.findAll());
        return "addbook"; // addbook.html
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book) {
        bRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bRepository.findById(bookId).orElse(null));
        model.addAttribute("categorylist", cRepository.findAll()); // Add this for the dropdown
        return "editBook";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bRepository.deleteById(bookId);
        return "redirect:/booklist";
    }

}
