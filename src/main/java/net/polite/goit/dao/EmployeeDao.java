package net.polite.goit.dao;

import net.polite.goit.dao.model.Employee;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public interface EmployeeDao {
    void save(Employee employee);

    Employee load(long id);

    List<Employee> findAll();
}
