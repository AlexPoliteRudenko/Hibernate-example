package net.polite.goit;

import net.polite.goit.controllers.DishController;
import net.polite.goit.controllers.EmployeeController;
import net.polite.goit.controllers.OrderController;
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
    private OrderController orderController;

    private boolean reInit;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }
    public void init() {
        if (reInit) {
            orderController.removeAllOrders();
            dishController.removeAllDishes();
            employeeController.removeAllEmployees();

            employeeController.initEmployees();
            dishController.initDishes();
            orderController.initOrders();
        }
    }


    private void start() {
/*        employeeController.createEmployee();
        System.out.println("List of Employees:");
        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.createDish();
        System.out.println("List of Dishes:");
        dishController.getAllDishes().forEach(System.out::println);

//        System.out.println(employeeController.getEmployeeByName("John"));
//        System.out.println(dishController.getDishByName("Plov"));

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Plov");
        dishes1.add("Salad");
        orderController.createOrder("John", dishes1, 1);
        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Meat");
        dishes2.add("Potato");
        orderController.createOrder("John", dishes2, 3);

        System.out.println("Orders:");
//        System.out.println(orderController.getAllOrders());
        orderController.printAllOrders();*/


//        employeeController.printEmployee(1L);
        employeeController.printEmployee(2L);
//        orderController.printAllOrders();
//        orderController.getAllOrders().forEach(System.out::println);
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setReInit(boolean reInit) {
        this.reInit = reInit;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
