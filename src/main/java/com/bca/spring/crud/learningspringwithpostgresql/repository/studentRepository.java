package com.bca.spring.crud.learningspringwithpostgresql.repository;

import com.bca.spring.crud.learningspringwithpostgresql.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class studentRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public studentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student insert(Student student){
        String sql = "INSERT into student " + "(student_first_name, student_last_name, student_email) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, student.getStudent_first_name());
                preparedStatement.setString(2, student.getStudent_last_name());
                preparedStatement.setString(3, student.getStudent_email());
                return preparedStatement;

            }
        }, keyHolder);

        Map<String, Object> keys = keyHolder.getKeys();
        if(keys != null && !keys.isEmpty() && keys.containsKey("student_id")) {
            long generatedStudentId = (long) keys.get("student_id");
            student.setStudentId(generatedStudentId);
        } else{
            throw new IllegalStateException("Generated Key not found or valid");
        }
        return student;
    }

    public List<Student> displayStudent(){
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
    }

    public void deleteStudentById(long student_id){
        String sql = "DELETE FROM student WHERE student_id = ?";
        jdbcTemplate.update(sql, student_id);
    }
}
