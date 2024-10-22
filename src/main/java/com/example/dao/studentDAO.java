package com.example.dao;

import com.example.models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.*;

public class studentDAO {
    private static final String url = "jdbc:mysql://localhost:3306/TEST";
    private static final String username = "root";
    private static final String password = "";

    private static final String INSERT_STUDENT_SQL = "INSERT INTO studentManagement (name, email, dob) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM studentManagement";
    private static final String UPDATE_STUDENT_SQL = "UPDATE studentManagement SET name = ?, email = ?, dob = ? WHERE id = ?";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM studentManagement WHERE id = ?";
    private static final String SELECT_STUDENT_BY_ID = "SELECT id, name, email, dob FROM studentManagement WHERE id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // CRUD operations
    public studentDAO() {
    }

    public void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(student.getDob().getTime())); // Corrected date conversion
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, new java.sql.Date(student.getDob().getTime())); // Corrected date conversion
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printStudents() throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date dob = resultSet.getDate("dob");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", DOB: " + dob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student selectStudent(int id) throws SQLException, ClassNotFoundException {
        Student student = null;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date dob = resultSet.getDate("dob");
                student = new Student(id, name, email, dob);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date dob = resultSet.getDate("dob");
                students.add(new Student(id, name, email, dob));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}