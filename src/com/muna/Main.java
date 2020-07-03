package com.muna;

import java.text.NumberFormat;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //Constants
        final byte MONTHS_IN_YEAR = 12;
        final byte percent = 100;
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        //Variables
        int principal;
        float annualInterestRate;
        float monthlyInterestRate;
        double numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        //Principal
        
        while(true){ 
            System.out.println("Principal: ");
    
            principal = scanner.nextInt();
            if(principal > 1_0000 && principal < 1_000_000){ 
                System.out.println("Your principal is " + principal);
                break;
            } 
            System.out.println("Please enter a number between 1000 and 1,000,000.");
        }

        //Interest rate
        while(true){ 

            System.out.println("Annual Interest rate: ");
    
            annualInterestRate = scanner.nextFloat();
    
            monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / percent;
            if(annualInterestRate > 0 && annualInterestRate <= 25){
                System.out.println("Your monthly interest rate will be: " + monthlyInterestRate);
                break;
            }
            System.out.println("The interest rate must be between 0 and 25 percent.");
        }


        //Period(years)
        while(true){
            System.out.println("Period(years): ");
            double years = scanner.nextDouble();
            
            if(years >= 10 && years < 40){ 
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            } 
            System.out.println("You must enter a number between 10 and 40.");
        }   



        //Mortgage
        System.out.println("Mortgage: ");

        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String mortgageFormatted = currency.format(mortgage);

    
        System.out.println("Your mortgage will be " + mortgageFormatted + " per month.");


        scanner.close();

        }
    }
