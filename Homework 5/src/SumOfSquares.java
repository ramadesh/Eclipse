import java.util.Scanner;

public class SumOfSquares 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); //scanner variable created
		System.out.println("Please enter an integer:");
		int userInt = scanner.nextInt();
		scanner.nextLine();
		int sum = 0;
		int i = 1;
		while (userInt > sum)
		{
			sum += i * i;
			i++;
		}
		System.out.println("The sum is " + sum);
	}
	
	
}
