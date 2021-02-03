package service;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/manageruser";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Nguyenhai@0603";

    protected final String SELECT_ALL = "SELECT * FROM user";
    protected final String INSERT_INTO = "INSERT INTO user(name,email,country) values(?,?,?)";
    protected final String SELECT_USER = "SELECT * FROM user where id = ?";
    protected final String UPDATE_USER = "UPDATE user SET name = ?,email = ?,country=? where id = ?";
    protected final String DELETE_USER = "DELETE FROM user where id = ?";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> showAll() throws SQLException {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                User user = new User(id, name, email, country);
                list.add(user);
            }
        }
        return list;
    }

    @Override
    public void addUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
        ) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void editUser(int id, User user) throws SQLException {
    try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
    ){
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getEmail());
        preparedStatement.setString(3,user.getCountry());
        preparedStatement.setInt(4,id);

        preparedStatement.executeUpdate();
    }
    }

    @Override
    public void removeUser(int id) throws SQLException {
    try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
    ){
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }
    }

    @Override
    public User findById(int id) throws SQLException {
        User user=null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);
        ) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user=new User (id,name,email,country);
            }
            return user;
        }
    }
}
