package az.rahil.ipoteca.model;

import java.math.BigDecimal;

public class Summary {

    private BigDecimal totalPay;
    private BigDecimal basePay;
    private BigDecimal interestPay;

    public Summary(BigDecimal totalPay, BigDecimal basePay, BigDecimal interestPay) {
        this.totalPay = totalPay;
        this.basePay = basePay;
        this.interestPay = interestPay;
    }

    public Summary() {
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public BigDecimal getBasePay() {
        return basePay;
    }

    public void setBasePay(BigDecimal basePay) {
        this.basePay = basePay;
    }

    public BigDecimal getInterestPay() {
        return interestPay;
    }

    public void setInterestPay(BigDecimal interestPay) {
        this.interestPay = interestPay;
    }

    @Override
    public String toString() {
        return
                "Cemi Borc = " + totalPay +
                ", Esas Borc = " + basePay +
                ", Faiz = " + interestPay;
    }
}
