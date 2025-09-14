package hh.be.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String getBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", new Book());
        return "index"; // index.html
    }

    @GetMapping("/booklist")
    public String getBookList(@ModelAttribute Book book, Model model) {
        model.addAttribute("booklist", repository.findAll());
        return "booklist"; // booklist.html
    }

    @GetMapping("/addbook")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // create.html
    }

    @PostMapping("/savebook")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{isbn}")
    public String editBook(@PathVariable Long isbn, Model model) {
        model.addAttribute("book", repository.findById(isbn).orElse(null));
        return "editBook";
    }

    @GetMapping("/deletebook/{isbn}")
    public String deleteBook(@PathVariable Long isbn, Model model) {
        repository.deleteById(isbn);
        return "redirect:/booklist";
    }

}
