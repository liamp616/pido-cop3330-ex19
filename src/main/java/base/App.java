/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Liam Pido
 */

/*
Exercise 19 - BMI Calculator
You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.

Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight in pounds.
The program should prompt the user for weight and height.

Calculate the BMI by using the following formula:

bmi = (weight / (height × height)) * 703
If the BMI is between 18.5 and 25, display that the person is at a normal weight.
If they are out of that range, tell them if they are underweight or overweight and tell them to consult their doctor.

Example Output

Your BMI is 19.5.
You are within the ideal weight range.

or

Your BMI is 32.5.
You are overweight. You should see your doctor.

Constraint

Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.

Challenges

Make the user interface accept height and weight in Imperial or metric units. You’ll need a slightly different formula for metric units.
For Imperial measurements, prompt for feet and inches and convert feet to inches so the user doesn’t have to.
Use a GUI interface with sliders for height and weight. Update the user interface on the fly. Use colors as well as text to indicate health.
 */

package base;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        double weight = myApp.readWeight();
        double height = myApp.readHeight();
        myApp.calculate(weight, height);
    }

    public void calculate(double weight, double height) {
        double BMI = Math.round(((weight / (height * height)) * 703) * 100.0) / 100.0;
        System.out.println("Your BMI is " + BMI + ".");

        if(BMI <= 25 && BMI >= 18.5) {
            System.out.println("You are within the ideal weight range.");
        } else {
            System.out.println("You are overweight. You should see your doctor.");
        }

    }

    public double readHeight() {
        boolean isNumber;
        double height = 0;
        System.out.print("What is your height? (in inches) ");
        do {
            if(in.hasNextInt()) {
                height = in.nextInt();
                isNumber = true;
            } else {
                System.out.print("What is your height? (in inches) ");
                isNumber = false;
                in.next();
            }
        } while (!(isNumber));

        return height;
    }


    public double readWeight() {
        boolean isNumber;
        double weight = 0;
        System.out.print("What is your weight? ");
        do {
            if(in.hasNextInt()) {
                weight = in.nextInt();
                isNumber = true;
            } else {
                System.out.print("What is your weight? ");
                isNumber = false;
                in.next();
            }
        } while (!(isNumber));

        return weight;
    }



}
