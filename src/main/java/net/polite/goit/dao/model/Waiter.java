package net.polite.goit.dao.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
@Entity
public class Waiter extends Employee {
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
//    @Fetch(FetchMode.JOIN)
    private List<Order> orders;

    public Waiter() {
    }

    public Waiter(String name, String surname, String phoneNumber, Position position, Float salary) {
        super(name, surname, phoneNumber, position, salary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter{").append("\n");
        sb.append("    id=").append(getId()).append("'\n");
        sb.append("    name='").append(getName()).append("'\n");
        sb.append("    surname='").append(getSurname()).append("'\n");
        sb.append("    Orders: {").append("\n");
        orders.forEach(order -> sb.append("        ").append(order).append("\n"));

        sb.append("    }\n");
        sb.append("}\n");
        return sb.toString();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
