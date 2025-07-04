package Elevatelab;

import java.util.Scanner;

class Account
{
    protected String accountHolder;
    protected long accountNumber;
    protected double balance;

    public Account(String accountHolder,long accountNumber,double balance)
    {
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount)
    {
        balance+=amount;
        System.out.println("Deposited ₹" + amount);
    }

    public void withdraw(double amount) 
    {
        if (amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } 
        else
        {
            System.out.println("Insufficient balance.");
        }
    }

    public void showBalance() 
    
    {
        System.out.println("Balance: ₹" + balance);
    }
}

class SavingsAccount extends Account 
{

    public SavingsAccount(String accountHolder, long accountNumber, double balance)
    {
        super(accountHolder, accountNumber, balance);
    }


    @Override
    public void withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn from Savings Account: ₹" + amount);
        } 
        
        else
        {
            System.out.println("Not enough balance in Savings Account.");
        }
    }
}


public class BankSimulation {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name=sc.nextLine();

        System.out.print("Enter account number: ");
        long accNo=sc.nextLong();

        SavingsAccount acc=new SavingsAccount(name, accNo, 1000.0);

        int choice;
        
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    acc.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    acc.withdraw(sc.nextDouble());  
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
