package com.bca.spring.crud.learningspringwithpostgresql.repository;

import com.bca.spring.crud.learningspringwithpostgresql.Model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}
