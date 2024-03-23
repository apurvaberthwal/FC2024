import java.util.Scanner;

interface CreditCardInterface {
    void viewCreditAmount();
    void payCard();
}

class SilverCardCustomer implements CreditCardInterface {
    String name;
    String cardNumber;
    double creditAmount;
    double creditLimit;

    SilverCardCustomer(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.creditAmount = 0;
        this.creditLimit = 50000;
    }

    public void viewCreditAmount() {
        System.out.println("Credit Amount for " + name + ": " + creditAmount);
    }

    public void payCard() {
        System.out.println("Payment made for Silver Card Customer " + name);
        creditAmount = 0;
    }

    public void useCard(double amount) {
        if (creditAmount + amount <= creditLimit) {
            creditAmount += amount;
            System.out.println("Transaction successful for Silver Card Customer " + name);
        } else {
            System.out.println("Transaction failed! Exceeds credit limit for Silver Card Customer " + name);
        }
    }
}

class GoldCardCustomer extends SilverCardCustomer {
    int limitIncreaseCount;

    GoldCardCustomer(String cardNumber, String name) {
        super(cardNumber, name);
        this.creditLimit = 100000;
        this.limitIncreaseCount = 0;
    }

    public void viewCreditAmount() {
        System.out.println("Credit Amount for Gold Card Customer " + name + ": " + creditAmount);
    }

    public void payCard() {
        System.out.println("Payment made for Gold Card Customer " + name);
        creditAmount = 0;
    }

    public void useCard(double amount) {
        if (creditAmount + amount <= creditLimit) {
            creditAmount += amount;
            System.out.println("Transaction successful for Gold Card Customer " + name);
        } else {
            System.out.println("Transaction failed! Exceeds credit limit for Gold Card Customer " + name);
        }
    }

    public void increaseLimit(double amount) {
        if (limitIncreaseCount < 3 && creditLimit + amount <= 105000) {
            creditLimit += amount;
            limitIncreaseCount++;
            System.out.println("Credit limit increased for Gold Card Customer " + name + " to " + creditLimit);
        } else {
            System.out.println("Limit increase failed for Gold Card Customer " + name);
        }
    }
}

public class Credit_Card {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
            
            SilverCardCustomer silverCustomer = new SilverCardCustomer("1456328879895648", "Gaurav");
            GoldCardCustomer goldCustomer = new GoldCardCustomer("5456328879895643", "Avinash");

            silverCustomer.useCard(30000);
            silverCustomer.useCard(30000);
            silverCustomer.viewCreditAmount();
            silverCustomer.payCard();

            goldCustomer.useCard(80000);
            goldCustomer.useCard(40000);
            goldCustomer.viewCreditAmount();
            goldCustomer.increaseLimit(5000);
            goldCustomer.increaseLimit(5000);
          
        }
    }

