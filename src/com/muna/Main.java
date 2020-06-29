package com.muna;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        //principal
        Scanner scanner = new Scanner(System.in); //Create a scanner object
        while (true) {
            System.out.println("Principal: ");
            principal = scanner.nextInt(); //Read user input and trim any whitespace
            if (principal > 1_000 && principal < 1_000_000) {
                System.out.println(principal);
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000");

        }

            //monthly interest rate
            while (true) {
                System.out.println("Annual interest rate: ");
                float interestRate = scanner.nextFloat();

                if (interestRate >= 1 && interestRate <= 30) {
                    monthlyInterestRate = interestRate / PERCENT / MONTHS_IN_YEAR;
                    break;
                }
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            }


            //Period
            while (true) {
                System.out.println("Period: ");
                byte period = scanner.nextByte();

                if (period >= 1 && period <= 30) {
                    numberOfPayments = period / MONTHS_IN_YEAR;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }


            //Mortgage
            double mortgage = principal*(monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
            String mortgageFormatted = currency.format(mortgage);

            System.out.println("Mortgage: " + mortgageFormatted);

            scanner.close();
        }
    }
