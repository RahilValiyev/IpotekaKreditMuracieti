package az.rahil.ipoteca.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Home {
    private int id;
    private BigDecimal price;

    public Home() {
    }

    public Home(BigDecimal price) {
        this.price = price;
    }

    public Home(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return id == home.id &&
                Objects.equals(price, home.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
