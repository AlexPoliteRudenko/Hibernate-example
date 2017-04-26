package net.polite.goit.dao;

import net.polite.goit.dao.model.Order;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public interface OrderDao {
    void save(Order order);

    List<Order> findAll();

    Order load(long id);

    void delete(Order order);
}
