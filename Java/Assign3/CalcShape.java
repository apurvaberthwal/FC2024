//Calculate area, volume for sphere, cone, ccylinder, box
import java.util.*;

abstract class Shape
{
    abstract double calc_area();
    abstract double cal_volume();
}

class Sphere extends Shape
{
    private double radius;

    Sphere(double radius)
    {
        this.radius = radius;
    }

    double calc_area()
    {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    double cal_volume()
    {
        return (4.0/3) * Math.PI * Math.pow(radius, 3);
    }
}

class Cone extends Shape
{
    private double radius;
    private double height;

    Cone(double radius, double height)
    {
        this.radius = radius;
        this.height = height;
    }

    double calc_area()
    {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

    double cal_volume()
    {
        return (1.0/3) * Math.PI * Math.pow(radius, 2) * height;
    }
}

class Cylinder extends Shape
{
    private double radius;
    private double height;

    Cylinder(double radius, double height)
    {
        this.radius = radius;
        this.height = height;
    }

    double calc_area()
    {
        return 2 * Math.PI * radius * (radius + height);
    }

    double cal_volume()
    {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

class Box extends Shape
{
    private double length;
    private double breadth;
    private double height;

    Box(double length, double breadth, double height)
    {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    double calc_area()
    {
        return 2 * (length * breadth + length * height + breadth * height);
    }

    double cal_volume()
    {
        return length * breadth * height;
    }
}

public class CalcShape {
    private static void display(String shapeName, Shape shape)
    {
        System.out.println("\n" + shapeName + " Details: ");
        System.out.println("Area: " +shape.calc_area());
        System.out.println("Volume: " +shape.cal_volume());
    }

    public static void main(String[] args) {
        Shape sphere = new Sphere(5.0);
        Shape cone = new Cone(3.0, 5.0);
        Shape cylinder = new Cylinder(2.0, 6.0);
        Shape box = new Box(3.0, 4.0, 5.0);

        display("Sphere", sphere);
        display("Cone", cone);
        display("Cylinder", cylinder);
        display("Box", box);
    }
}