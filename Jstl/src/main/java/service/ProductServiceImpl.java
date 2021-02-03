package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/productmanager";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Nguyenhai@0603";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final String SELECT_ALL = "SELECT * FROM product";
    private final String INSERT_INTO = "insert into product(name,price,brand) values(?,?,?)";

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException throwables) {
            System.out.println("ok");
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String brand = resultSet.getNString("brand");

                Product product = new Product(id, name, price, brand);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;

    }

    @Override
    public void addProdcut(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)
        ) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getBrand());
        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public Product editProduct(int id, Product product) {
        return null;
    }

    @Override
    public void removeProduct(int id) {
    }
}
