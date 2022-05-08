package com.alexej_arhipenko.book_manager.dao;

import com.alexej_arhipenko.book_manager.model.Book;
import com.alexej_arhipenko.book_manager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Book save(Book book, long userId) {
        logger.info("Save" + book);

        if (get(book.id(), userId) == null) {
            return null;
        }
        book.setUser(em.getReference(User.class, userId));
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public boolean delete(long id, long userId) {

        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .setParameter("user_id", userId)
                .executeUpdate() != 0;
    }

    @Override
    public Book get(long id, long userId) {
        Book book = em.find(Book.class, id);
        return book != null && book.getUser().getId() == userId ? book : null;
    }

    @Override
    public List<Book> getAll(long userId) {
        logger.info("Get all");
        return em.createNamedQuery(Book.GET_ALL, Book.class)
                .setParameter("user_id", userId)
                .getResultList();
    }
}
