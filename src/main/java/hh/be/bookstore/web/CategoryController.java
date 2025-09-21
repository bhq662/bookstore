package hh.be.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.be.bookstore.domain.Category;
import hh.be.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
    private CategoryRepository cRepository;

    public CategoryController(CategoryRepository cRepository) {
        this.cRepository = cRepository;
    }

    @GetMapping("/categorylist")
    public String getMethodName(@ModelAttribute Category category, Model model) {
        model.addAttribute("categorylist", cRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    @GetMapping("/addcategory")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        cRepository.save(category);
        return "redirect:/categorylist";
    }

}
