/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 * Name: Md Sadikur Rahman 
 * ID: 12248860
 * Purpose: Purpose of this program
 * is to calculate Employee wage based on their skill level.Here I create a
 * driver class and a main method for Employee Wage Recording System where we
 * can create one object for Wage class and by using this object we can access
 * the data from Wage class. I use for loop for taking input for N number of
 * employee and do while loop for input validation. After all the calculation we will get
 * a data set as a table and statistics of the data. 
 *
 * @author MD.SADIKUR RAHMAN
 */
public class EmployeeWageRecordingSystem {

    /**
     * Main Method of the Program, From where Compiler will start compilation.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Constant Variable For Number of Employee
        int N = 8; // Highest digit of my ID;

        //Scanner Object for taking input from user.
        Scanner input = new Scanner(System.in);

        //Creating Object for Wage Class
        Wage wage = new Wage();

        // Displaying Welcome Message Using methods 
        wage.displayWelcomeMessage();

        // Variables 
        double minSalary = Double.MAX_VALUE; // For minmum Salary
        double maxSalary = Double.MIN_VALUE; // For maximum Salary 
        double totalSalary = 0; // Total Salary
        String workedLessThan10 = ""; // For Counting less than 10 hours worked
        String workedBetween10To20 = ""; // for counting between 10 - 20 hours worked
        String workedMoreThan20 = ""; // For counting more than 20 hours worked
        String minSalaryName = ""; // For identifying minimum salary earnd by who
        String maxSalaryName = ""; // For identifying maximum salary earnd by who

        // For Table data header 
        String table = "Employee Name  |  SkillLevel  |  Hours Worked  |  Over Time \n";

        // For loop for n number of Employee 
        for (int i = 1; i <= N; i++) {

            // Validating Employee Name using do While Loop
            String name;
            do {
                System.out.printf("Enter the name of the Employee - %d : ", i);
                name = input.nextLine(); // Taking input from user
                if (name.isEmpty()) {
                    System.out.println("ERROR!. Employee Name can't be Empty!"); // Validation message
                }
            } while (name.isEmpty()); // End of do While Loop

            // Validating Skill Level Using Do while Loop
            int skillLevel;
            do {
                System.out.printf("Enter the Skill Level (1 2 or  3) of the Employee %s : ", name);
                skillLevel = input.nextInt(); // Taking input from user
                if (skillLevel < 1 || skillLevel > 3) {
                    System.out.printf("ERROR!.Enter a Valid Skill Level (1 2 or 3) Level Should not be %d : %n", skillLevel);
                }
            } while (skillLevel < 1 || skillLevel > 3); // do While loop end

            input.nextLine(); // For Next new Line input

            // Validating Hours Worked By each Employee 
            int hoursWorked;
            do {
                System.out.printf("Enter the Hours (integer) Worked by the Emloyee %s : ", name);
                hoursWorked = input.nextInt(); // Taking input from user
                if (hoursWorked < 0) {
                    System.out.println("Enter a positive value work hours");
                }
            } while (hoursWorked < 0); // End of do while loop

            input.nextLine(); // For next new line input 

            // Calculating The Salary using Wage Class and CalculateSalary method
            double salary = wage.calculateSalary(skillLevel, hoursWorked);

            // Updating minimum Salary Value 
            if (salary < minSalary) {
                minSalary = salary;
                minSalaryName = name;
            }
            // Updating maximum Salary Value
            if (salary > maxSalary) {
                maxSalary = salary;
                maxSalaryName = name;
            }
            // Updating Total Salary
            totalSalary += salary;

            // Updating Hours Worked by the 
            if (hoursWorked < 10) {
                workedLessThan10 += "*";
            } else if (hoursWorked > 10 && hoursWorked < 20) {
                workedBetween10To20 += "*";
            } else {
                workedMoreThan20 += "*";
            }

            // Printing the details for each Employee 
            System.out.printf("The Wage of Employee %s <Level: %d> For %d hours is = %.2f %n", name, skillLevel, hoursWorked, salary);

            // Collecting all information for Table format 
            table += name + "\t \t \t" + skillLevel + "\t \t" + hoursWorked + "\t \t" + wage.overTime(hoursWorked) + "\n";

        } // End of For Loop

        // Disply the Table Data for all Employe
        System.out.println("Below is the Data Set");
        System.out.println("---------------------------------------------------");
        System.out.println(table);  // printing Table Data

        // Display Statistical Information and Bar Charts
        System.out.println("Statistical Information & Bar Charts");
        System.out.println("----------------------------------------");
        System.out.printf("Minimum of The Salaries $%.2f  (earned by) %s %n", minSalary, minSalaryName); // Minimum Salary Earned 
        System.out.printf("Maximum of The Salaries $%.2f  (earned by) %s %n", maxSalary, maxSalaryName); // Maximum Salary Earned
        System.out.printf("Average Salary is: $%.2f %n", totalSalary / N); // Showing Average Salary

        System.out.println("Bar Chart of the Lenth of Worked Hours");

        System.out.printf("Number of Employee Who Works Less Than 10 Hours  %s %n", workedLessThan10); // Less Than 10 hours
        System.out.printf("Number of Employee Who Works 10 - 20 Hours  %s %n", workedBetween10To20); // between 10 - 20 hours
        System.out.printf("Number of Employee Who Works above 20 Hours  %s %n", workedMoreThan20); // Above 20 hours

        // Calling this methods for Eanding Message 
        wage.displayEandingMessage();

    } // End of Main Method

}
