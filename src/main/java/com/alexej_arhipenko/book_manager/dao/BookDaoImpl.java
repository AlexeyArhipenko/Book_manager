package com.alexej_arhipenko.book_manager.dao;

import com.alexej_arhipenko.book_manager.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BookDaoImpl implements BookDao {

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Book save(Book book) {
        logger.info("Save" + book);
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public boolean delete(long id) {

        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public Book get(long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        logger.info("Get all");
        return em.createNamedQuery(Book.GET_ALL, Book.class).getResultList();
    }
}
