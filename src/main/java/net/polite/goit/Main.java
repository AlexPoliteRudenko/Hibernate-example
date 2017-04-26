package net.polite.goit;

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

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();

    }

    private void start() {
        employeeController.createEmployee();

    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
