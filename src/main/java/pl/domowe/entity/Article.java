package pl.domowe.entity;

import lombok.Data;
import pl.domowe.entity.Author;
import pl.domowe.entity.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;
    @OneToMany
    private List<Category> category;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
}
