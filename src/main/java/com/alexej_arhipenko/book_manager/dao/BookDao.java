package com.alexej_arhipenko.book_manager.dao;

import com.alexej_arhipenko.book_manager.model.Book;

import java.util.List;

public interface BookDao {
    Book save(Book book, long userId);

    boolean delete(long id, long userId);

    Book get(long id, long userId);

    List<Book> getAll(long userId);
}
