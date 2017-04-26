package net.polite.goit.dao.hibernate;

import net.polite.goit.dao.OrderDao;
import net.polite.goit.dao.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public class OrderDaoHibernate implements OrderDao {
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Order").list();
    }

    @Override
    public Order load(long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
