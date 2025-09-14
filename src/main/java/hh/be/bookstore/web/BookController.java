package hh.be.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

}
