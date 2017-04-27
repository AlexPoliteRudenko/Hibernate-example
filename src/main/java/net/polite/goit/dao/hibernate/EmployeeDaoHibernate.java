package net.polite.goit.dao.hibernate;

import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public Employee findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee e where e.name like :name");
        query.setParameter("name", name);
        return (Employee) query.uniqueResult();

    }

    @Override
    public void deleteAll() {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee").executeUpdate();
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public Employee load(long id) {
        return sessionFactory.getCurrentSession().load(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Employee").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
