package az.rahil.ipoteca.bussiness;

import az.rahil.ipoteca.model.Cutomer;
import az.rahil.ipoteca.model.Home;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckCustomer {


    public static boolean check() {
        Scanner sc = new Scanner(System.in);
        IpotecaCalculator ipotecaCalculator = new IpotecaCalculator();
        Cutomer cust = new Cutomer();

        System.out.println("");
        System.out.println("Adinizi daxil edin");
        String name = sc.nextLine();
        System.out.println("Soyadinizi daxil edin");
        String surname = sc.nextLine();
        System.out.println("Dogum tarixini daxil edin");
        LocalDate date = (LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Evin deyeri");
        BigDecimal homePrise = sc.nextBigDecimal();
        System.out.println("----------------------");

        System.out.println("Dogum Tarixi = " + date);
        Home home = new Home();
        home.setPrice(homePrise);
        cust.setName(name);
        cust.setSurname(surname);
        cust.setDob(date);
        Boolean result = ipotecaCalculator.isEligible(cust);
        if (result) {
            CalculationResult calculationResult = ipotecaCalculator.calculate(home);
            System.out.println("---------------------------------------------");
            calculationResult = ipotecaCalculator.calcSummary();
            calculationResult.getMonthlyPaymentList().forEach(System.out::println);
            System.out.println("--------------------------------------");
            System.out.println();
            System.out.println(calculationResult.getSummaries());
            return true;
        } else {
            System.out.println("Yas uygun deyil!!");
            return false;
        }


    }
}
