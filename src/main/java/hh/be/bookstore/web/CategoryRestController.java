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

import hh.be.bookstore.domain.Category;
import hh.be.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryRestController {
    private CategoryRepository categoryRepository;

    public CategoryRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // RESTful service to get all categories
    // Java-kielinen Category-luokan oliolista muunnetaan JSON-kategorialistaksi ja
    // lähetetään web-selaimelle vastauksena
    @GetMapping("/api/categorylist")
    public @ResponseBody List<Category> findAllCategoriesList() {
        return (List<Category>) categoryRepository.findAll();
    }

    // RESTful service to get category by id
    @GetMapping("/api/categorylist/{id}")
    public @ResponseBody Optional<Category> getOneCategoryRest(@PathVariable(name = "id") Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // RESTful service to save new category
    @PostMapping("/api/categorylist")
    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

}
