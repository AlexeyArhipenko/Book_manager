package com.alexej_arhipenko.book_manager.dao;

import com.alexej_arhipenko.book_manager.model.Book;

import java.util.List;

public interface BookDao {
    Book save(Book book);

    boolean delete(long id);

    Book get(long id);

    List<Book> getAll();
}
