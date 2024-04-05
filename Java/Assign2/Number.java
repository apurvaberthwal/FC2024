import java.util.Scanner;
import NumOperation.*;

public class Number{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.println("enter no. of elements : ");
	int num=scanner.nextInt();
	for(int i=0;i<num;i++) {

        System.out.print("Enter a number (n): ");
	
        int n = scanner.nextInt();
	
        if (PrimeNumber.isPrime(n)) {
            System.out.println(n + " is a Prime Number.");
        } else {
            System.out.println(n + " is not a Prime Number.");
        }

        if (PerfectNumber.isPerfect(n)) {
            System.out.println(n + " is a Perfect Number.");
        } else {
            System.out.println(n + " is not a Perfect Number.");
        }

        if (ArmstrongNumber.isArmstrong(n)) {
            System.out.println(n + " is an Armstrong Number.");
        } else {
            System.out.println(n + " is not an Armstrong Number.");
        }
	}
    }
}

