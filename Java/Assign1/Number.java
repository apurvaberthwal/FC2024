class MyNumber
{
private
	int num;
public
    // Default Constructor
	MyNumber()
	{
		num = 0;
	}
    // Parameterized Constructor
	MyNumber(int num)
	{
		this.num = num;
	}
   
	void checkNum()
	{
		if (this.num > 0)
			System.out.println("Number is Positive");
		else if(this.num < 0)
			System.out.println("Number is Negative");
		else if(num == 0)
			System.out.println("Number is Zero");
	}

	void checkEvenOdd()
	{
		if (this.num % 2 == 0)
			System.out.println("Number is Even");
		else
			System.out.println("Number Is Odd");
	}

}


public class Number 
{
	public static void main(String[] args) 
	{
		if(args.length != 1)
		{
			System.out.println("enter One Number Only as a Command Line Argument");
			System.exit(0);
		}

		MyNumber num = new MyNumber(Integer.parseInt(args[0]));

		num.checkNum();
		num.checkEvenOdd();

	}
}














    

