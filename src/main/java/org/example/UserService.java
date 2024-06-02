package org.example;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserDetails(int userId) {
        return userRepository.findUserById(userId);
    }

    public void registerUser(User user) {
        userRepository.saveUser(user);
    }
}

