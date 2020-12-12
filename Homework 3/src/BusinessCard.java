import java.util.Scanner;
/**
 * BusinessCard
 *
 * Asks the user for input on many personal questions 
 * and prints all the responses in a summary format 
 * at the end
 *
 * @author Rama Deshpande, CS1800 Merge
 * @version September 8, 2020
 *
 */
public class BusinessCard 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //scanner created for user to respond to questions
		
		System.out.println("Enter your name: "); 
		String name = scanner.nextLine(); //user inputs their name
		
		System.out.println("Enter your age: ");
		int age = scanner.nextInt(); //user inputs their age
		scanner.nextLine();
		
		System.out.println("Enter your GPA: ");
		double gpa = scanner.nextDouble(); //user inputs their GPA
		scanner.nextLine();
		
		System.out.println("Enter your major: ");
		String major = scanner.nextLine(); //user inputs their major
		
		System.out.println("Enter your email: ");
		String email = scanner.nextLine(); //user inputs their email
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.printf("GPA: %.2f", gpa);
		System.out.println();
		System.out.println("Major: " + major);
		System.out.println("Email: " + email);
		
	}

}


/*
import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Age and Name");
        //int input
        int age = scanner.nextInt();
        // String input
        String name = scanner.nextLine();
        System.out.println(name + ", " + age);
    }
}
*/
/*
Enter your name:
[John Doe]
Enter your age:
[18]
Enter your gpa:
[3.2]
Enter your major:
[Computer Science]
Enter your email:
[jdoe@purdue.edu]
Name: John Doe
Age: 18
GPA: 3.20
Major: Computer Science
Email: jdoe@purdue.edu
*/