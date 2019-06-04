package az.rahil.ipoteca.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class MonthlyPayment {

    private int numberOfMonth;
    private LocalDate payDate;
    private BigDecimal totalAmount;
    private BigDecimal baseAmount;
    private BigDecimal interest;

    public MonthlyPayment(int numberOfMonth, LocalDate payDate, BigDecimal totalAmount, BigDecimal baseAmount, BigDecimal interest) {
        this.numberOfMonth = numberOfMonth;
        this.payDate = payDate;
        this.totalAmount = totalAmount;
        this.baseAmount = baseAmount;
        this.interest = interest;


    }

    public MonthlyPayment() {

    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public void setNumberOfMonth(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthlyPayment that = (MonthlyPayment) o;
        return numberOfMonth == that.numberOfMonth &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(baseAmount, that.baseAmount) &&
                Objects.equals(interest, that.interest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfMonth, payDate, totalAmount, baseAmount, interest);
    }

    @Override
    public String toString() {
        return
                "Aylarin Sirasi = " + numberOfMonth +
                ", Odenis Tarixi = " + payDate +
                ", Toplam Borc = " + totalAmount +
                ", Ayliq Borc = " + baseAmount +
                ", Ayliq Faiz = " + interest;
    }
}
