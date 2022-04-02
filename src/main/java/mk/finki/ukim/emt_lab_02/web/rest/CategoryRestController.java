package mk.finki.ukim.emt_lab_02.web.rest;

import mk.finki.ukim.emt_lab_02.model.Category;
import mk.finki.ukim.emt_lab_02.model.dto.CategoryDto;
import mk.finki.ukim.emt_lab_02.service.BookService;
import mk.finki.ukim.emt_lab_02.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://library-manager-193181.herokuapp.com/")
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
    private final BookService bookService;
    public CategoryRestController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/count")
    public List<CategoryDto> findAllByCount(){
        return bookService.findAllByCategories();
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }
}
