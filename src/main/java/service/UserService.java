package service;

import entities.User;

import java.util.List;

public interface UserService {
     User createUser(User user);
     List<User> getUsers();
     User getUser(Long id);

     User updateUser(Long id, User user);

     Boolean deleteUser(Long id);
}
