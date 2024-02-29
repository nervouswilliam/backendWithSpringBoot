package com.bca.spring.crud.learningspringwithpostgresql.Controller;

import com.bca.spring.crud.learningspringwithpostgresql.Exception.ResourceNotFoundException;
import com.bca.spring.crud.learningspringwithpostgresql.Model.Employees;
import com.bca.spring.crud.learningspringwithpostgresql.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeesController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping("/employees")
    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }

    @PostMapping("/employees")
    public Employees createEmployees(@RequestBody Employees employees){
        return employeesRepository.save(employees);
    }

    @GetMapping("/employees/{Id}")
    public ResponseEntity<Employees> getEmployeesByID(@PathVariable Long Id){
        Employees employees = employeesRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + Id));
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/employees/{Id}")
    public ResponseEntity<Employees> updateEmployees(@PathVariable Long Id, @RequestBody Employees employeesDetail){
        Employees employees = employeesRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + Id));
        employees.setFirstName(employeesDetail.getFirstName());
        employees.setLastName(employeesDetail.getLastName());
        employees.setEmailId(employeesDetail.getEmailId());

        Employees updatedEmployees = employeesRepository.save(employees);
        return ResponseEntity.ok(updatedEmployees);
    }

    @DeleteMapping("/employees/{Id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployees(@PathVariable Long Id){
        Employees employees = employeesRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + Id));
        employeesRepository.delete(employees);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
