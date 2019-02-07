package pl.domowe.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import pl.domowe.entity.Article;
import pl.domowe.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
        Hibernate.initialize(article.getCategoryList());
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
            Hibernate.initialize(article.getCategoryList());
        }
        return articleList;
    }

    public List<Article> readLastNth(int i) {
        Query query = entityManager.createQuery("SELECT a FROM Article a order by a.id desc");
        List<Article> articleList = query.setMaxResults(i).getResultList();
        for (Article article : articleList) {
            Hibernate.initialize(article.getAuthor());
            Hibernate.initialize(article.getCategoryList());
        }
        return articleList;
    }

//    public List<Article> readAllInCategory(Category categoryId) {
//        List<Category> objects = new ArrayList<>();
//        objects.add(categoryId);
//        Query query = entityManager.createQuery("SELECT a FROM Article a where a.categoryList in (:categoryId)");
//        query.setParameter("categoryId", objects);
//        List<Article> articleList = query.getResultList();
//        for (Article article : articleList) {
//            Hibernate.initialize(article.getAuthor());
//            Hibernate.initialize(article.getCategoryList());
//        }
//        return articleList;
//    }

    public List<Article> readAllInCategory(long category) {
        Query query = entityManager.createQuery("SELECT a FROM Article a join a.categoryList category where category.id in (:category)");
        query.setParameter("category", category);
        List<Article> burgers = query.getResultList();
        return burgers;
    }

}
