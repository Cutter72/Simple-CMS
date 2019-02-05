package pl.domowe.dao;

import org.hibernate.Hibernate;
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
        Article article = entityManager.find(Article.class, id);
        Hibernate.initialize(article.getAuthor());
        Hibernate.initialize(article.getCategory());
        return article;
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
        for (Article article : articleList) {
            Hibernate.initialize(article.getAuthor());
            Hibernate.initialize(article.getCategory());
        }
        return articleList;
    }

    public List<Article> readLastNth(int i) {
        Query query = entityManager.createQuery("SELECT a FROM Article a order by a.id desc");
        List<Article> articleList = query.setMaxResults(i).getResultList();
        for (Article article : articleList) {
            Hibernate.initialize(article.getAuthor());
            Hibernate.initialize(article.getCategory());
        }
        return articleList;
    }

}
