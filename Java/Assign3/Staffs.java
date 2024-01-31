//Staff FullTime, PartTime

import java.util.*;

abstract class Staff
{
    String name;
    String address;

    Staff()
    {
        name = "";
        address = "";
    }

    Staff(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    public void display()
    {
        System.out.println("\nName of Staff: " +name);
        System.out.println("Address of Staff: " +address);
    }
}

class FullTimeStaff extends Staff
{
    String department;
    float salary;

    FullTimeStaff()
    {
        super();
        department = "";
        salary = 0;
    }

    FullTimeStaff(String name, String address, String department, float salary)
    {
        super(name, address);
        this.department = department;
        this.salary = salary;
    }

    public void display()
    {
        super.display();
        System.out.println("Department of Staff: " +department);
        System.out.println("Salary of Staff: " +salary);
    }
}

class PartTimeStaff extends Staff
{
    int noOfHours;
    float ratePerHour;

    PartTimeStaff()
    {
        noOfHours = 0;
        ratePerHour = 0;
    }

    PartTimeStaff(String name, String address, int noOfHours, float ratePerHour)
    {
        super(name, address);
        this.noOfHours = noOfHours;
        this.ratePerHour = ratePerHour;
    }

    public void display()
    {
        super.display();
        System.out.println("Number of Hours: " +noOfHours);
        System.out.println("Rate per Hour: " +ratePerHour);
    }
}

public class Staffs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("If you want to create objects for FullTimeStaff press: 1");
        System.out.println("If you want to create objects for PartTimeStaff press: 2");
        int choice = sc.nextInt();

        System.out.print("Enter number of objects: ");
        int n = sc.nextInt();

        FullTimeStaff fts[] = new FullTimeStaff[n];
        PartTimeStaff ptf[] = new PartTimeStaff[n];

        for(int i=0; i<n; i++)
        {
            System.out.print("\nEnter the name of staff: " +(i+1));
            String name = sc.next();

            System.out.print("Enter the address of staff: ");
            String address = sc.next();

            if(choice == 1)
            {
                System.out.print("Enter department of staff: ");
                String department = sc.next();

                System.out.print("Enter salary of staff: ");
                float salary = sc.nextFloat();

                fts[i] = new FullTimeStaff(name, address, department, salary);
            }
            else if(choice == 2)
            {
                System.out.print("Enter Number of Hours of Staff: ");
                int noOfHours = sc.nextInt();

                System.out.print("Enter Rate per Hour: ");
                int ratePerHour = sc.nextInt();

                ptf[i] = new PartTimeStaff(name, address, noOfHours, ratePerHour);
            }
            else
            {
                System.out.println("Invalid choice!");
                return;
            }
        }

        System.out.println("\nDetails of Staff: ");
        for(int i=0; i<n; i++)
        {
            if(choice == 1)
            {
                fts[i].display();
            }
            else
            {
                ptf[i].display();
            }
        }
    }
}