package az.rahil.ipoteca.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Cutomer {
    private int id;
    private String name;
    private String surname;
    private LocalDate dob;
    private BigDecimal salary;

    public Cutomer() {
    }

    public Cutomer(LocalDate dob) {
        this.dob = dob;
    }

    public Cutomer(int id, String name, String surname, LocalDate dob, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cutomer cutomer = (Cutomer) o;
        return id == cutomer.id &&
                Objects.equals(name, cutomer.name) &&
                Objects.equals(surname, cutomer.surname) &&
                Objects.equals(dob, cutomer.dob) &&
                Objects.equals(salary, cutomer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dob, salary);
    }

    @Override
    public String toString() {
        return "Cutomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                '}';
    }
}
