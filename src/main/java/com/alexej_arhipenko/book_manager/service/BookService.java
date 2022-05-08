package com.alexej_arhipenko.book_manager.service;


import com.alexej_arhipenko.book_manager.model.Book;

import java.util.List;

public interface BookService {
    Book get(long id, long userId);

    void delete(long id, long userId);

    Book create(Book book, long userId);

    Book update(Book book, long userId);

    List<Book> getAll(long userId);

    void makeRead(long id, boolean readAlready, long userId);
}
