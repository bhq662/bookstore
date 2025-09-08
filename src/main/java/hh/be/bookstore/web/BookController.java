package hh.be.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import hh.be.bookstore.domain.Book;

@Controller
public class BookController {

    @GetMapping("/index")
    public String getBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", new Book());
        return "index"; // index.html
    }

}
