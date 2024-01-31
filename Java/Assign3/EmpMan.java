//Employee class
import java.util.*;

class Employee
{
    private int id;
    private String name;
    private String department;
    private float salary;

    Employee()
    {
        id = 0;
        name = "";
        department = "";
        salary = 0;
    }

    Employee(int id, String name, String department, float salary)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display()
    {
        System.out.println("\nEmployee ID is: " +id);
        System.out.println("Employee Name: " +name);
        System.out.println("Employee Department: " +department);
        System.out.println("Employee Salary: " +salary);
    }

    public float getSalary()
    {
        return salary;
    }
}

class Manager extends Employee
{
    private float bonus;

    Manager()
    {
        super();
        bonus = 0;
    }

    Manager(int id, String name, String department, float salary, float bonus)
    {
        super(id, name, department, salary);
        this.bonus = bonus;
    }

    public void display()
    {
        super.display();
        System.out.println("Bonus is: " +bonus);
        System.out.println("Total Salary (Salary + Bonus) is: " +(getSalary() + bonus));
    }

    public float getTotalSalary()
    {
        return getSalary() + bonus;
    }
}

public class EmpMan
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of managers: ");
        int n = sc.nextInt();
        
        Manager m[] = new Manager[n];

        for(int i=0; i<n; i++)
        {
            System.out.println("\nEnter details of Manager " +(i+1));
            System.out.print("Enter the ID: ");
            int id = sc.nextInt();

            System.out.print("Enter the Name: ");
            String name = sc.next();

            System.out.print("Enter the Department: ");
            String department = sc.next();

            System.out.print("Enter the Salary: ");
            float salary = sc.nextFloat();

            System.out.print("Enter the Bonus: ");
            float bonus = sc.nextFloat();

            m[i] = new Manager(id, name, department, salary, bonus);
        }

        Manager maxSalary = m[0];

        for(int i=1; i<n; i++)
        {
            if(m[i].getTotalSalary() > maxSalary.getTotalSalary())
            {
                maxSalary = m[i];
            }
        }

        System.out.println("\nDetails of Manager with Maximum Salary: ");
        maxSalary.display();
    }
}