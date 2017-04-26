package net.polite.goit.controllers;

import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.model.Employee;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public class EmployeeController {
    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
/*
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0f);
*/

        employeeDao.save(employee);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
