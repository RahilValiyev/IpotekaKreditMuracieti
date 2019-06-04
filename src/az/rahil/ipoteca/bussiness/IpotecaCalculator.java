package az.rahil.ipoteca.bussiness;

import az.rahil.ipoteca.model.Cutomer;
import az.rahil.ipoteca.model.Home;
import az.rahil.ipoteca.model.MonthlyPayment;
import az.rahil.ipoteca.model.Summary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class IpotecaCalculator {

    public static int maxDuration = 25;
    public static int interestForYears = 8;
    public static BigDecimal creditAmount = BigDecimal.valueOf(150);
    public static int age = 65;
    public static long countofMonth = 0;


    public BigDecimal basePay = BigDecimal.valueOf(0);
    public BigDecimal totalPay;
    public BigDecimal interestPay;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static LocalDate dateNow = LocalDate.now();
    CalculationResult calculationResult=new CalculationResult();


    public static boolean isEligible(Cutomer custom) {
        long aylar;
        LocalDate date = custom.getDob();
        LocalDate pensiyaYasi = date.plusYears(age);
        LocalDate creditLastdate = dateNow.plusYears(25);
        System.out.println("Bugun = " + dateNow);
        System.out.println("Pensiya yasi = " + pensiyaYasi);
        System.out.println("Kreditin son gunu = " + creditLastdate);
        countofMonth = ChronoUnit.MONTHS.between(dateNow, creditLastdate);
        aylar = ChronoUnit.MONTHS.between(creditLastdate, pensiyaYasi);

        System.out.println("kreditin son gunu ve bugun arasindaki aylarin sayi" + countofMonth);
        System.out.println();
        if (aylar > 12) {
            return true;

        } else {
            return false;
        }

    }


    public CalculationResult calculate(Home home) {

        MonthlyPayment monthlyPayment;
        basePay = home.getPrice().multiply(BigDecimal.valueOf(80)).divide(BigDecimal.valueOf(100), RoundingMode.valueOf(2));

        BigDecimal UmumiFaiz = basePay.multiply(BigDecimal.valueOf(8).divide(BigDecimal.valueOf(100)));
        BigDecimal baseAmount = basePay.divide(BigDecimal.valueOf(countofMonth), RoundingMode.valueOf(2));

        System.out.println("Evin qiymeti = " + home.getPrice());
        System.out.println("Bank verdiyi kredit = " + basePay);
        System.out.println("Umumi faiz = " + UmumiFaiz);
        System.out.println("Ayliq  odenis = " + baseAmount);

        //ayliq kredit faizi
        BigDecimal ayliqfaiz = UmumiFaiz.divide(BigDecimal.valueOf(countofMonth), RoundingMode.valueOf(2));
        System.out.println("Ayliq KreditFaizi = " + ayliqfaiz);

        //cemi kredit borcu
        totalPay = UmumiFaiz.add(basePay);

        //cemi faiz borcu
        interestPay = UmumiFaiz;

        BigDecimal totalAmount = baseAmount.add(ayliqfaiz);
        System.out.println("Toplam Ayliq Odenis = " + totalAmount);
        System.out.println("-------------------------------------------------------");
        System.out.println();

        for (int i = 0; i <= countofMonth; i++) {

            monthlyPayment = new MonthlyPayment();
            monthlyPayment.setNumberOfMonth(i + 1);
            monthlyPayment.setPayDate(LocalDate.now().plusMonths(i + 1).withDayOfMonth(1));
            monthlyPayment.setInterest(ayliqfaiz);
            monthlyPayment.setBaseAmount(baseAmount);
            monthlyPayment.setTotalAmount(totalAmount);
            calculationResult.getMonthlyPaymentList().add(monthlyPayment);

        }

        return calculationResult;
    }


    public CalculationResult calcSummary() {
        Summary summary=new Summary();
        summary.setBasePay(basePay);
        summary.setTotalPay(totalPay);
        summary.setInterestPay(interestPay);
        calculationResult.setSummaries(summary);
        return calculationResult;
    }
}
