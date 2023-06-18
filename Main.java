package com.codewithkani;

public class Main {
    public static void main(String[] args) {
        Avdrag mortgage = new Avdrag();

        double loanAmount = mortgage.getLoanAmount();
        double interestRate = mortgage.getRate();
        int yearsToPay = mortgage.getYearsToPay();

        double monthlyPayment = mortgage.calculateMonthlyPayment(loanAmount, yearsToPay);
        System.out.println("The Monthly Payment will be $USD : " + monthlyPayment);
    }
}


