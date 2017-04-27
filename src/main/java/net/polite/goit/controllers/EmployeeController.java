package net.polite.goit.controllers;

import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.model.Employee;
import net.polite.goit.dao.model.Position;
import net.polite.goit.dao.model.Waiter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */

@Transactional
public class EmployeeController {
    private EmployeeDao employeeDao;

    public void initEmployees() {

        Waiter john = new Waiter("John", "Smith", "555-55-55", Position.WAITER, 25000.0f);
        employeeDao.save(john);
        Waiter mary = new Waiter("Mary", "Smith", "555-55-55", Position.WAITER, 20000.0f);
        employeeDao.save(mary);
    }

/*    public void createEmployee() {
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());


        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
    }*/

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void removeAllEmployees() {
        employeeDao.deleteAll();
    }

    public void printEmployee(long id) {
        System.out.println(employeeDao.load(id));
    }
}
