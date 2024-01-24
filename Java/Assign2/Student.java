import java.util.*;
import MScCAII.*;
import MScCAI.*;

public class Student {
    
    int rollNumber;
	String name;
	MScCAIMarks msccaimarks;
	MScCAIIMarks msccaiimarks;
	

	public Student(int rollNumber, String name,MScCAIMarks msccaimarks, MScCAIIMarks msccaiimarks) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.msccaimarks = msccaimarks;
		this.msccaiimarks = msccaiimarks;
	}

	public String calGrade(int total) {
		int per= total/4;
		
		if (per>=70) {
			return "A";
		} else if (per<=60 && per>=49) {
			return "B";
		}else if (per<=50 && per>=39) {
			return "C";
		}else if (per<=40) {
			return "FAIL";
		}
		return "Grade not found";
	}
  
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of student");
        int num = scanner.nextInt();
        Student[] student = new Student[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter roll number");
            int rollNumber = scanner.nextInt();
            System.out.println("Enter name");
            String name = scanner.next();
            System.out.println("Enter MScCAI marks");
            System.out.println("Enter Sem1 marks");
            int semITotal = scanner.nextInt();
            System.out.println("Enter Sem2 marks");
            int semIITotal = scanner.nextInt();
            MScCAIMarks msccaimarks = new MScCAIMarks(semITotal, semIITotal);
            System.out.println("Enter MScCAII marks");
            System.out.println("Enter Sem1 marks");
            semITotal = scanner.nextInt();
            System.out.println("Enter Sem2 marks");
            semIITotal = scanner.nextInt();
            MScCAIIMarks msccaiimarks = new MScCAIIMarks(semITotal, semIITotal);
            student[i] = new Student(rollNumber, name, msccaimarks, msccaiimarks);
        }
        System.out.println("Student Details");
        
        for (int i = 0; i < num; i++) {
            System.out.println("Roll Number: " + student[i].rollNumber);
            System.out.println("Name: " + student[i].name);
            System.out.println(student[i].msccaimarks);
            System.out.println(student[i].msccaiimarks);
            int total = student[i].msccaimarks.totalMarksI() + student[i].msccaiimarks.totalMarksII();
            System.out.println("Total Marks: " + total);
            System.out.println("Grade: " + student[i].calGrade(total));
        }
        scanner.close();

	}


}
