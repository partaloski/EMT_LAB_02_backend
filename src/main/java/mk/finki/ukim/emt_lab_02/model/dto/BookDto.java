package mk.finki.ukim.emt_lab_02.model.dto;

import lombok.Data;
import mk.finki.ukim.emt_lab_02.model.Author;
import mk.finki.ukim.emt_lab_02.model.Category;

@Data
public class BookDto {
    private String name;
    private Long author;
    private String category;
    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Long author, String category, Integer availableCopies) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
