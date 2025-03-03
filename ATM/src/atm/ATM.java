/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm;

import java.util.Scanner;

/*
 * @author A.TAFA.TATERA
 */
public class ATM {

    
    static Scanner scan = new Scanner(System.in);
    static double accountBalance = 1000.00;
   
    public static void main(String[] args) {
        
        int action;
           do {
            System.out.println("ATM menu");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");

            System.out.print("Enter Action : ");
             action = scan.nextInt();

            switch (action) {
                case 1: withdraw();
                    System.out.println();
                    break;
                case 2: deposit();
                    System.out.println();
                    break;
                case 3: checkBalance();
                    System.out.println();
                    break;
                case 4: System.out.println("Thank you for banking with Us");
                    break;
                default:
                    System.out.println("invalid Input");
                    break;
            }
        } while (action != 4);
      scan.close();
    }
    
    
    
    public static void withdraw() {
        System.out.print("Enter withdraw amount : ");
        
        double amount = scan.nextDouble();
        
        if (amount != 0 && amount <= accountBalance) {
            System.out.println("Successful withdraw " + amount);
            accountBalance -= amount;
            return;
        }
        
        System.out.println("Insufficient Funds");
         
    }
    
    
    public static void deposit() {
        System.out.print("Enter Deposite amount : ");
        
        double amount = scan.nextDouble();
        if (amount == 0 || amount <= 0) {
            System.out.println("Inavalid Deposit amount");
            return;
        }
        
        System.out.println("Successful deposit " + amount);
        accountBalance += amount; 
    }
    
    
    public static void checkBalance() {
        
        System.out.println("Account Balance : " + accountBalance); 
    }
    
}
