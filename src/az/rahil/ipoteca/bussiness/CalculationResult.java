package az.rahil.ipoteca.bussiness;

import az.rahil.ipoteca.model.MonthlyPayment;
import az.rahil.ipoteca.model.Summary;
import java.util.ArrayList;
import java.util.List;

public class CalculationResult {


    List<MonthlyPayment> monthlyPaymentList = new ArrayList<>();
    Summary summaries ;


    public CalculationResult() {

    }

    public CalculationResult(List<MonthlyPayment> monthlyPaymentList, Summary summaries) {
        this.monthlyPaymentList = monthlyPaymentList;
        this.summaries = summaries;
    }

    public List<MonthlyPayment> getMonthlyPaymentList() {
        return monthlyPaymentList;
    }

    public void setMonthlyPaymentList(List<MonthlyPayment> monthlyPaymentList) {
        this.monthlyPaymentList = monthlyPaymentList;
    }

    public Summary getSummaries() {
        return summaries;
    }

    public void setSummaries(Summary summaries) {
        this.summaries = summaries;
    }

    public CalculationResult result() {


        return null;
    }
}
