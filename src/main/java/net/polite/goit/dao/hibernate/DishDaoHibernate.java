package net.polite.goit.dao.hibernate;

import net.polite.goit.dao.DishDao;
import net.polite.goit.dao.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
@Transactional
public class DishDaoHibernate implements DishDao {

    private SessionFactory sessionFactory;

    @Override
    public List<Dish> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Dish").list();
    }

    @Override
    public Dish load(long id) {
        return null;
    }

    @Override
    public void delete(Dish dish) {
        sessionFactory.getCurrentSession().delete(dish);
    }

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
