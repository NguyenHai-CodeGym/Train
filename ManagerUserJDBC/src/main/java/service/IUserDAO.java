package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> showAll() throws SQLException;

    void addUser(User user) throws SQLException;

    void editUser(int id, User user) throws SQLException;

    void removeUser(int id) throws SQLException;

    User findById(int id) throws SQLException;


}
