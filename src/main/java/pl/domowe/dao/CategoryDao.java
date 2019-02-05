package pl.domowe.dao;

import org.springframework.stereotype.Component;
import pl.domowe.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Category entity) {
        entityManager.persist(entity);
    }

    public Category read(long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category entity) {
        entityManager.merge(entity);
    }

    public void delete(Category entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void deleteById(long id) {
        delete(read(id));
    }

    public List<Category> readAll() {
        Query query = entityManager.createQuery("SELECT id FROM Category id");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }
}
