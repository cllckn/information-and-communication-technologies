package cc.ku.ict.module5.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductPostgresqlImplementation implements IProductRepository {
    private Connection conn;

    private void connect() {
        try {
            String URL = "jdbc:postgresql://localhost:5432/ecommercedb";
            String USER = "postgres";
            String PASSWORD = "LecturePassword";

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database.");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product save(Product product) {
        connect();
        String sql = "INSERT INTO products (name, price) VALUES (?, ?) RETURNING id";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int generatedId = rs.getInt("id");
                product.setId(generatedId);
                System.out.println("Product added successfully: " + product.getName());
                return product;
            }
        } catch (SQLException e) {
            System.out.println("Failed to save product: " + product.getName());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null; // return null if insert fails
    }


    @Override
    public Product findById(int productId) {
        connect();
        Product product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        connect();
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return products;
    }

    @Override
    public void update(Product product) {
        connect();
        String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getId());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with ID: " + product.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteById(int productId) {
        connect();
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
