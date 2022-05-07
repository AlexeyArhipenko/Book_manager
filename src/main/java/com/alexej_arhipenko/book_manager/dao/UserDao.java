package com.alexej_arhipenko.book_manager.dao;

import com.alexej_arhipenko.book_manager.model.User;

import java.util.List;

public interface UserDao {

    User save(User user, long userId);

    boolean delete(long id);

    User get(long id);

    User getByEmail(String email);

    List<User> getAll();
}
