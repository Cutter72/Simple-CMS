package pl.domowe.dao;

import org.springframework.stereotype.Component;
import pl.domowe.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Article entity) {
        entityManager.persist(entity);
    }

    public Article read(long id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article entity) {
        entityManager.merge(entity);
    }

    public void delete(Article entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void deleteById(long id) {
        delete(read(id));
    }

    public List<Article> readAll() {
        Query query = entityManager.createQuery("SELECT id FROM Article id");
        List<Article> articleList = query.getResultList();
        return articleList;
    }
}
