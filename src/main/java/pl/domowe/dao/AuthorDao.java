package pl.domowe.dao;

import org.springframework.stereotype.Component;
import pl.domowe.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Author entity) {
        entityManager.persist(entity);
    }

    public Author read(long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity));
    }

    public void deleteById(long id) {
        delete(read(id));
    }

    public List<Author> readAll() {
        Query query = entityManager.createQuery("SELECT id FROM Author id");
        List<Author> authorList = query.getResultList();
        return authorList;
    }
}
