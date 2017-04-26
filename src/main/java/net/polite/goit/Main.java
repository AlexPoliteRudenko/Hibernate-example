package net.polite.goit;

import net.polite.goit.controllers.DishController;
import net.polite.goit.controllers.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
public class Main {
    private EmployeeController employeeController;
private DishController dishController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();
        System.out.println("List of Employees:");
        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.createDish();
        System.out.println("List of Dishes:");
        dishController.getAllDishes().forEach(System.out::println);
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
