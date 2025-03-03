/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myproject;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Student name : ");
        String studentName = scan.nextLine();
        
        System.out.println("Marks out of 100");
        
        System.out.print("Enter Maths mark: ");
        int mathMark = scan.nextInt();
        
        System.out.print("Enter English mark: ");
        int englishMark = scan.nextInt();
        
        System.out.print("Enter Science mark: ");
        int scienceMark = scan.nextInt();
        
        System.out.print("Enter History mark: ");
        int historyMark = scan.nextInt();
        
        System.out.print("Enter Business mark: ");
        int businessMark = scan.nextInt();
        
        System.out.print("Enter Geography mark: ");
        int geographyMark = scan.nextInt();
        System.out.println();
        
        System.out.println("Student " +studentName + " Achieved");
        System.out.println();
        
        int sumTotal = mathMark + englishMark + scienceMark + historyMark + businessMark + geographyMark;
        System.out.println("Sum Total: " + sumTotal + " out of 600");
        
        
        float averagePercent = ((float) sumTotal / 600) * 100;
        System.out.println("Average Percent: " + averagePercent);
        
        
        if (averagePercent >= 90) {
            System.out.println("A+ Distinction");
        } else if (averagePercent >= 80) {
            System.out.println("A - Excellent");
        } else if (averagePercent >= 70) {
            System.out.println("B - Good");
        } else if (averagePercent >= 60) {
            System.out.println("C - Satisfactory");
        } else if (averagePercent >= 50) {
            System.out.println("D - Pass");
        } else if (averagePercent >= 40) {
            System.out.println("E - Below Average");
        } else {
            System.out.println("F - Fail");
        }

        
        scan.close();
    }
}
