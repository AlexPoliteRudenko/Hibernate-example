package net.polite.goit.dao.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * {@link }
 *
 * @author Oleksii Polite Rudenko
 * @version 1.0
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee waiter;

    @ManyToMany/*(fetch = FetchType.EAGER)*/(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @Column(name = "table_number")
    private int tableNumber;

    @Column(name = "order_date")
    private LocalDateTime localDateTime;

    public Order() {
    }

    public Order(Employee waiter, List<Dish> dishes, int tableNumber, LocalDateTime localDateTime) {
        this.waiter = waiter;
        this.dishes = dishes;
        this.tableNumber = tableNumber;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", localDateTime=" + localDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (tableNumber != order.tableNumber) return false;
        if (waiter != null ? !waiter.equals(order.waiter) : order.waiter != null) return false;
        if (dishes != null ? !dishes.equals(order.dishes) : order.dishes != null) return false;
        return localDateTime != null ? localDateTime.equals(order.localDateTime) : order.localDateTime == null;
    }

    @Override
    public int hashCode() {
        int result = waiter != null ? waiter.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        result = 31 * result + tableNumber;
        result = 31 * result + (localDateTime != null ? localDateTime.hashCode() : 0);
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
