package com.codewithkani;

import java.util.Scanner;

public class Avdrag {
    private double loanAmount;
    private double interestRate;
    private int yearsToPay;

    public double getLoanAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the loan amount: ");
        loanAmount = scanner.nextDouble();
        return loanAmount;
    }

    public double getRate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the annual interest rate (e.g., 0.05 for 5%): ");
        String rateInput = scanner.nextLine();

        // Remove percentage symbol if present
        rateInput = rateInput.replaceAll("%", "");

        // Validate and convert the rate
        double rate;
        try {
            rate = Double.parseDouble(rateInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid interest rate. Please enter a valid decimal number.");
            return getRate(); // Retry getting the rate
        }

        interestRate = rate;
        return interestRate;
    }

    public int getYearsToPay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of years to pay down the loan: ");
        yearsToPay = scanner.nextInt();
        return yearsToPay;
    }

    public double calculateMonthlyPayment(double loanAmount, int yearsToPay) {
        int numberOfMonths = yearsToPay * 12;
        double monthlyInterestRate = interestRate / 12;

        double monthlyPayment = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);

        return monthlyPayment;
    }
}
