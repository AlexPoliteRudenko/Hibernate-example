package net.polite.goit.controllers;

import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.model.Employee;
import net.polite.goit.dao.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */

@Transactional
public class EmployeeController {
    private EmployeeDao employeeDao;

    public void createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());
        Employee employee = new Employee();
//        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0f);

        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
