package net.polite.goit.dao;

import net.polite.goit.dao.model.Dish;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public interface DishDao {
    void save(Dish dish);

    List<Dish> findAll();

    Dish load(long id);

    void delete(Dish dish);
}
