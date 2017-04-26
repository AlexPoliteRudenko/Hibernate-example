package net.polite.goit.dao.hibernate;

import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public class EmployeeDaoHibernate implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(long id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
