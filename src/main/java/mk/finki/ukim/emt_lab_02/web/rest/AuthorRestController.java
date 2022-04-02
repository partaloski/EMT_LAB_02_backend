package mk.finki.ukim.emt_lab_02.web.rest;


import mk.finki.ukim.emt_lab_02.model.Author;
import mk.finki.ukim.emt_lab_02.model.Book;
import mk.finki.ukim.emt_lab_02.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://library-manager-193181.herokuapp.com/")
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAll();
    }
}
