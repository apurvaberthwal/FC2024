import java.util.*;

interface CreditCard {
    void viewCreditAmount();

    void increaseLimit() ;

    void useCard() ;

    void payCard() ;
}

class SliverCardCustomer implements CreditCard {
    String name;
    int card_no;
    double creditAmount;
    double creaditLimit;
    static int cnt;
Scanner sc=new Scanner(System.in);

    SliverCardCustomer() {
        name = "Noname";
        card_no = 0;
        creditAmount = 0;
        creaditLimit = 50000;
    }

    public void viewCreditAmount() {
        System.out.println("Your amount is : " + creditAmount);
    }

    public void getdata()  {
        System.out.println("Enter the name : ");
        String name = sc.next();
        System.out.println("Enter the card number :");
        card_no = sc.nextInt();
        System.out.println("Enter Credit amount : ");
        creditAmount = sc.nextDouble();
    }

    public void payCard()  {
        System.out.println("Enter amount to be pay");
        double pay = sc.nextDouble();
        creditAmount = creditAmount + pay;
        System.out.println("Balance is paid");
    }

    public void useCard()  {
        System.out.println("Enter amount : ");
        double amount = sc.nextDouble();
        if (amount < creditAmount) {
            creditAmount = creditAmount - amount;
            viewCreditAmount();
            System.out.println("Thanks for using the service");
        } else
            System.out.println("\nerror!");
    }

    public void increaseLimit() {
        cnt++;
        if (cnt <= 3) {
            System.out.println("Enter amount limit to increse : ");
            double amt = sc.nextDouble();
            if (amt <= 2500) {
                creaditLimit = creaditLimit + amt;
                System.out.println("Amount limit to increse Successfully : ");
            }
            System.out.println("You can't increse creadit amount more than 2500 at a time ");
        } else
            System.out.println("You can't increse limit more than 3 times ");
    }
}


class GoldCardCustomer extends SliverCardCustomer {
    static int cnt;

    public void increaseLimit()  {
        cnt++;
        if (cnt <= 3) {
            System.out.println("Enter amount limit to increse : ");
            double amt = sc.nextDouble();
            if (amt <= 5000) {
                creaditLimit = creaditLimit + amt;
                System.out.println("Amount limit to increse Successfully : ");
            }
            System.out.println("You can't increse creadit amount more than 2500 at a time ");
        } else
            System.out.println("You can't increse limit more than 3 times");
    }
}

class Q2 {
    public static void main(String args[])  {
        int ch;
        Scanner br=new Scanner(System.in);
        System.out.println("Enter info for silver card : ");
        SliverCardCustomer sc = new SliverCardCustomer();
        sc.getdata();
        System.out.println("Enter info for Gold card : ");
        GoldCardCustomer gc = new GoldCardCustomer();
        gc.getdata();
        do {
            System.out.println("1.Use silver card \n2.Pay credit for Silver card\n3.Increase limit for silver card ");
            System.out.println("4.Use Gold card \n5.Pay credit for Gold card\n6.Increase limit for Gold card ");
            System.out.println("0. exit");
            System.out.println("Enter your choice : ");
            ch = br.nextInt();
            switch (ch) {
                case 1:
                    sc.useCard();
                    break;
                case 2:
                    sc.payCard();
                    break;
                case 3:
                    sc.increaseLimit();
                    break;
                case 4:
                    gc.useCard();
                    break;
                case 5:
                    gc.payCard();
                    break;
                case 6:
                    gc.increaseLimit();
                    break;
                case 0:
                    break;
            }
        } while (ch != 0);
    }
}
