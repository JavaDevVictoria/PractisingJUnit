package org.example;

public interface UserRepository {
    User findUserById(int userId);
    void saveUser(User user);
}

