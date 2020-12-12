import java.util.Scanner;
/**
 * SignUp
 *
 * asks for input from user 
 * to sign up for a credit card 
 * and generates a username 
 * and confirmation code 
 * based on the info the user provides
 *
 * @author Rama Deshpande, CS1800 Merge
 * @version September 8, 2020
 *
 */
		
public class SignUp 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //scanner created for user 
		System.out.println("Full Name: "); 
		//stores the inputed firstName lastName as a string
		String fullName = scanner.nextLine();
        
		System.out.println("Date of Birth: ");
		String birthDate = scanner.nextLine(); //MM-DD-YYYY as a string
		birthDate = birthDate.substring(0, 2) 
            + "/" 
		    + birthDate.substring(3, 5) 
            + "/" 
		    + birthDate.substring(6);
		
		System.out.println("Annual Income: ");
		double annualIncome = scanner.nextDouble(); //annual income as a double
		scanner.nextLine();
		
		System.out.println("Social Security Number: ");
		String ssn = scanner.nextLine(); //user's 9 digit ssn
		
		System.out.println("Phone Number: ");
		long phoneNumLong = scanner.nextLong(); //user's phone number
		scanner.nextLine();
		String phoneNumString = "" + phoneNumLong; //user's phone number string
		phoneNumString = "(" + phoneNumString.substring(0, 3) 
            + ")" 
		    + phoneNumString.substring(3, 6) 
            + "-" 
            + phoneNumString.substring(6);
		
		System.out.println("Email: "); 
		String email = scanner.nextLine(); //stores the inputed email
		
		System.out.println("Address:"); 
		String address = scanner.nextLine(); //stores the inputed address
		String zip = address.substring(address.indexOf(",") + 1, address.length()); //separates the zip
		scanner.close();
        //first name only
		String firstName = fullName.substring(0, fullName.indexOf(" ")); 
		
		String lastName = fullName.substring(fullName.indexOf(" ") + 1, fullName.length()); //last name only
		
		String username = firstName.substring(0, 1) 
            + lastName 
            + birthDate.substring(3, 5); // creates username
		
		//ascii value of the last letter of the last name
		int confirmationCodePart1 = (int) lastName.charAt(lastName.length() - 1); 
		

        //first letter of the last name from fullName
		int firstLetterLastName = (int) lastName.charAt(0); 
        int birthMonth = Integer.parseInt(birthDate.substring(3, 5));
		char confirmationCodePart2 = (char)(birthMonth + firstLetterLastName); //the char version of the integer
		
		int confirmationCodePart3 = ((int) annualIncome) % 77; //remainder
		
		//last letter of the email before the @
		String confirmationCodePart4 = email.substring(email.indexOf("@") - 1, email.indexOf("@")); 
		
		//converts the phoneNumLong to string
		String confirmationCodePart5 = String.valueOf(phoneNumString); 
		confirmationCodePart5 = confirmationCodePart5.substring(1, 3);
		
		//prints all the given info
		System.out.println(firstName.substring(0, 1).toUpperCase() 
                           + firstName.substring(1).toLowerCase() 
                           + " " 
                           + lastName.substring(0, 1).toUpperCase() 
                           + lastName.substring(1).toLowerCase());
		System.out.println("Date of Birth: " + birthDate);
		System.out.printf("Income: $%.2f\n", annualIncome);
		System.out.println("SSN: XX-XXX-" + ssn.substring(5));
		System.out.println("Phone: " + phoneNumString);
		System.out.println("Email: " + email);
		System.out.println("Address:");
		System.out.println(address.substring(0, address.indexOf(",")));
		System.out.println(zip); 
		
		System.out.println("Username: " + username.toLowerCase());
		
		//print final confirmation code
		System.out.print("Confirmation Code: ");
		System.out.print(confirmationCodePart1);
		System.out.print(confirmationCodePart2);
		System.out.print(confirmationCodePart3);
		System.out.print(confirmationCodePart4);
		System.out.print(confirmationCodePart5);
		
		
	}
}
