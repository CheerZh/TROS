package ustc.zgq.service;

import java.util.List;

import ustc.zgq.entity.User;

public interface UserService {

    Boolean signIn(User user);
    Boolean register(User user);
    Boolean deleteUser(User user);
    Boolean updateUser(User user);

    List<User> getUsers();
}