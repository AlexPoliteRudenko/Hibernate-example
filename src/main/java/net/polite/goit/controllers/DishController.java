package net.polite.goit.controllers;

import net.polite.goit.dao.DishDao;
import net.polite.goit.dao.model.Dish;
import net.polite.goit.dao.model.DishCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public class DishController {
    private DishDao dishDao;

    public void initDishes() {
        Dish meat = new Dish("Meat", DishCategory.MAIN, 5.00f, 300f);
        Dish potato = new Dish("Potato", DishCategory.SIDE_DISH, 4.00f, 400f);
        Dish plov = new Dish("Plov", DishCategory.MAIN, 3.99f, 100f);
        Dish salad = new Dish("Salad", DishCategory.SALAD, 3.00f, 200f);

        dishDao.save(meat);
        dishDao.save(potato);
        dishDao.save(plov);
        dishDao.save(salad);
    }

/*    @Transactional
    public void createDish() {
        Dish meat = new Dish("Meat", DishCategory.MAIN, 5.00f, 300f);
//        meat.setName("Meat");
//        meat.setCategory(DishCategory.MAIN);
//        meat.setPrice(5.00f);
//        meat.setWeight(300f);
        Dish potato = new Dish("Potato", DishCategory.SIDE_DISH, 4.00f, 400f);
//        potato.setName("Potato");
//        potato.setCategory(DishCategory.SIDE_DISH);
//        potato.setPrice(4.00f);
//        potato.setWeight(400f);
        Dish plov = new Dish("Plov", DishCategory.MAIN, 3.99f, 100f);
//        plov.setName("Plov");
//        plov.setCategory(DishCategory.MAIN);
//        plov.setPrice(3.99f);
//        plov.setWeight(100f);
        Dish salad = new Dish("Salad", DishCategory.SALAD, 3.00f, 200f);

        Set<Dish> allDishes = new HashSet<>(getAllDishes());
        if (!allDishes.contains(meat)) {
            dishDao.save(meat);
        }
        if (!allDishes.contains(potato)) {
            dishDao.save(potato);
        }
        if (!allDishes.contains(plov)) {
            dishDao.save(plov);
        }
        if (!allDishes.contains(salad)) {
            dishDao.save(salad);
        }

    }*/

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void removeAllDishes() {
        dishDao.deleteAll();
    }
}
