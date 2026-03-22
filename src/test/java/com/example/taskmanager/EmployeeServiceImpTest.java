package com.example.taskmanager;

import com.example.taskmanager.entity.Employee;
import com.example.taskmanager.repo.EmployeeRepo;
import com.example.taskmanager.service.EmployeeService;
import com.example.taskmanager.service.EmployeeServiceImp;
import org.hibernate.boot.internal.Abstract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public  class EmployeeServiceImpTest {
    @Mock
    private EmployeeRepo employeeRepo;
    @InjectMocks
    private EmployeeServiceImp employeeService;
    private Employee emp;

    @BeforeEach
    void setUp(){
        emp = new Employee(1L,"John",50000.0,"john@gmail.com","IT");
    }
    @Test
    void createEmployeeTest(){
        Mockito.when(employeeRepo.save(emp)).thenReturn(emp);
        Employee saved=employeeService.createEmployee(emp);
        Assertions.assertEquals("IT",saved.getDepartment());
        Mockito.verify(employeeRepo).save(emp);


    }
    @Test
    void testGetEmployeeById_Success(){

        Mockito.when(employeeRepo.findById(1L)).thenReturn(Optional.of(emp));

        Employee result = employeeService.getEmployeeById(1L);

        Assertions.assertEquals("John", result.getName());

        Mockito.verify(employeeRepo).findById(1L);
    }


}
