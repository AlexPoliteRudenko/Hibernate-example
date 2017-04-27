package net.polite.goit.controllers;

import net.polite.goit.dao.DishDao;
import net.polite.goit.dao.EmployeeDao;
import net.polite.goit.dao.OrderDao;
import net.polite.goit.dao.model.Dish;
import net.polite.goit.dao.model.DishCategory;
import net.polite.goit.dao.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
@Transactional
public class OrderController {
    private OrderDao orderDao;
    private EmployeeDao employeeDao;
    private DishDao dishDao;


    public void initOrders() {
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");
        Order order1 = new Order(employeeDao.findByName("John")
                , createDishes(dishes1), 1, LocalDateTime.now());
        orderDao.save(order1);
        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Meat");
        dishes2.add("Potato");
        Order order2 = new Order(employeeDao.findByName("Mary")
                , createDishes(dishes2)
                , 1
                , LocalDateTime.now());
        orderDao.save(order2);
        orderDao.save(createOrderWithIceCream());
    }

    private Order createOrderWithIceCream() {
        List<Dish> dishes3 = new ArrayList<>();
        Dish iceCream = new Dish("Ice Cream", DishCategory.DESSERT, 3.0f,90f);
//        dishDao.save(iceCream);
        dishes3.add(iceCream);
        return new Order(employeeDao.findByName("Mary")
                , dishes3
                , 4
                , LocalDateTime.now());
    }

    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void printAllOrders() {
        getAllOrders().forEach(System.out::println);
    }

    public void removeAllOrders() {
        orderDao.deleteAll();
    }
}
