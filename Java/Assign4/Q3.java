import java.util.*;

class Vehicle {
    String company;
    double price;

    public void accept() {
        System.out.println("Enter Company and price of the Vehicle: ");
        Scanner sc=new Scanner(System.in);
        company = sc.next();
        price = sc.nextDouble();

    }

    public void display() {
        System.out.println("Company: " + company + " Price: " + price);
    }
}

class LightMotorVehicle extends Vehicle {
    double mileage;

    public void accept()  {
        super.accept();
        System.out.println("Enter mileage of vehicle: ");
        Scanner sc=new Scanner(System.in);
        mileage = sc.nextDouble();
    }

    public void display() {
        super.display();
        System.out.println("Mileage: " + mileage);
    }
}

class HeavyMotorVehicle extends Vehicle {
    double captons;

    public void accept()  {
        super.accept();
        System.out.println("Enter capacity of vehicle in tons: ");
        Scanner sc=new Scanner(System.in);
        captons = sc.nextDouble();
    }

    public void display() {
        super.display();
        System.out.println("Capacity in tons: " + captons);
    }
}

public class Q3 {
    public static void main(String[] args)  {
        int i,num=1;
        System.out.println("Enter type of vehicle: ");
        Scanner sc=new Scanner(System.in);
	while(num>0){
        System.out.println("1.Light Vehicle");
        System.out.println("2.Heavy Vehicle");
	System.out.println("3.Exit");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.println("Enter number of Light vehicles: ");
                int n = sc.nextInt();
                LightMotorVehicle[] l = new LightMotorVehicle[n];
                for (i = 0; i < n; i++) {
                    l[i] = new LightMotorVehicle();
                    l[i].accept();
                }
                for (i = 0; i < n; i++) {
                    l[i].display();
                }
                break;
            case 2:
                System.out.println("Enter the number of Heavy vehicles: ");
                int m =  sc.nextInt();
                HeavyMotorVehicle[] h = new HeavyMotorVehicle[m];
                for (i = 0; i < m; i++) {
                    h[i] = new HeavyMotorVehicle();
                    h[i].accept();
                }
                for (i = 0; i < m; i++) {
                    h[i].display();
                }
                break;
	case 3:
		num=0;
	}		
        }
    }
}
