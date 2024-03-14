/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 * Name: Md Sadikur Rahman 
 * ID: 12248860 
 * Purpose: Purpose of this Class is to
 * calculate wage related data for Employee Wage Recording System. Here I use
 * one default Constructor and one method for calculating the salary for each
 * employee and two Different methods for welcome and End message and one method
 * for updating the over time status for each employee
 *
 * @author MD.SADIKUR RAHMAN
 */
public class Wage {
    // Private Instance Variable 

    // Constant Variable For Skill Level 
    final double LEVEL1 = 50.00;
    final double LEVEL2 = 70.00;
    final double LEVEL3 = 100.00;

    /**
     * Default Constructor
     */
    public Wage() {
        // Default Constructor

    } // End of Constructor 

    /**
     * This method is for displaying the welcome message.
     */
    public void displayWelcomeMessage() {
        System.out.println("Welcome to m2ES Employee Wage Recording System");
        System.out.println("My ID is = 12248860,  8 is the highest digit");
        System.out.println("8 Employee details will be captured below.");

    }

    /**
     * This method is created for Calculating the Wage for Employee
     *
     * @param skillLevel
     * @param hoursWorked
     * @return
     */
    public double calculateSalary(int skillLevel, int hoursWorked) {
        double hourlyRate;
        switch (skillLevel) {

            case 1:
                hourlyRate = LEVEL1;
                break;

            case 2:
                hourlyRate = LEVEL2;
                break;

            case 3:
                hourlyRate = LEVEL3;
                break;

            default:
                hourlyRate = 0.0;
                break;
        }

        // Calculate Regular Hours and Over Time Hours Using Ternary Operator 
        double regularHours = (hoursWorked <= 40) ? hoursWorked : 40; // Regular hours will be till 40.
        double overtimeHours = (hoursWorked > 40) ? hoursWorked - 40 : 0; // Overtme Hours will start after 40.

        double regularPay = regularHours * hourlyRate;
        double overTimePay = overtimeHours * 1.5 * hourlyRate; // Overtime pay will be 1.5 times than regualr hours.

        return regularPay + overTimePay;

    } // End of Calculate Salary Method

    /**
     * This method is for updating the overTime status for each Employee
     *
     * @param hoursWorked
     * @return
     */
    public String overTime(double hoursWorked) {
        if (hoursWorked > 40) {
            return "Yes";
        } else {
            return "No";
        }
    }

    /**
     * This method is for Displaying The Ending message
     */
    public void displayEandingMessage() {
        System.out.println("Thank you for using the Employee Wage Recording System");
        System.out.println("Program Writen By 12248860");
    }

} // End of Wage Class
