package pl.domowe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @PrePersist
    public void onPrePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        updated = LocalDateTime.now();
    }
}
