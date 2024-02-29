package com.bca.spring.crud.learningspringwithpostgresql.Controller;

import com.bca.spring.crud.learningspringwithpostgresql.Model.Employees;
import com.bca.spring.crud.learningspringwithpostgresql.Model.Student;

import java.sql.*;

public class StudentController {
    private static final String URL = "jdbc:postgresql://localhost:5432/student";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "namaku81ll";

    public void createStudent(Student student) throws SQLException {
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
            String sql = "INSERT INTO student (first_name, last_name, email_id) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            Student student1 = null;
            statement.setString(1, student1.getStudent_first_name());
            statement.setString(2, student1.getStudent_first_name());
            statement.setString(3, student1.getStudent_email());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Student getStudentById(long id){
        Student student = null;
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM STUDENT WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email_id = resultSet.getString("email_id");
                student = new Student(first_name, last_name, email_id);
                student.setStudentId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


}
