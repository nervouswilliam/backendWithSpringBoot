package com.bca.spring.crud.learningspringwithpostgresql.Model;

public class Student {
    private long studentId;
    private String student_first_name;
    private String student_last_name;
    private String student_email;

    public Student(String student_first_name, String student_last_name, String student_email) {
        this.student_first_name = student_first_name;
        this.student_last_name = student_last_name;
        this.student_email = student_email;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudent_first_name() {
        return student_first_name;
    }

    public void setStudent_first_name(String student_first_name) {
        this.student_first_name = student_first_name;
    }

    public String getStudent_last_name() {
        return student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        this.student_last_name = student_last_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
