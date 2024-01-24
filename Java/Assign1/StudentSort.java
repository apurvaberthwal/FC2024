import java.io.*;


class Student
{
	int roll_no;
	String name;
	float percentage;

	Student()
	{
		roll_no = 0;
		name = "";
		percentage = 0;
	}

	Student(int roll, String name, float per)
	{
		this.roll_no = roll;
		this.name = name;
		this.percentage = per;
	}

	public String toString()
	{
		return "[ Roll No : " + this.roll_no + "\t Name : " + this.name + "\t percentage : " + this.percentage +" ]";
	}

	
}

class StudentSort
{
	static void sortStudent(Student S[], int n)
    {
        //Bubble Sort
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (S[j].percentage > S[j+1].percentage)
                {
                    // swap arr[j+1] and arr[j]
                    Student temp = S[j];
                    S[j] = S[j+1];
                    S[j+1] = temp;
                }
       for (int i=0; i<n; i++) {
       	System.out.println(S[i]);
       }
    }

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("How Many Records : ");
		int n = Integer.parseInt(br.readLine());

		Student s[] = new Student[n];

		for (int i=0; i<n; i++)
		{
			System.out.println("Enter roll Number : ");			
			int roll = Integer.parseInt(br.readLine());

			System.out.println("Enter Name : ");
			String name = br.readLine();

			System.out.println("Enter Percentage : ");
			float per = Float.parseFloat(br.readLine());

			s[i] = new Student(roll, name, per);
		}

		sortStudent(s, n);
	}
} 