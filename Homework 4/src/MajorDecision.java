import java.util.Scanner;
/**
 * A program that asks a series of yes/no questions
 * to the user to help them decide which major they would be a best fit for
 * depending on their preferences.
 * 
 *
 * @author Rama Deshpande, CS180 Merge
 * @version September 20, 2020
 */
public class MajorDecision 
{
	
	public static final String WELCOME_MESSAGE = "Hi! Welcome to the major decider. Answer \"Yes\" or \"No\" to " 
				+ "our questions.";
	public static final String ALREADY_KNOW = "Do you already know which major you want?";
	public static final String MATH = "Do you like math?";
	public static final String PEOPLE = "Do you like talking to people?";
	public static final String TEACHING = "Do you like teaching?";
	public static final String SCIENCES = "Do you like the sciences?";
	public static final String MONEY = "Do you think of ways to make money?";
	public static final String LANGUAGES = "Do you like languages?";
	public static final String ENGLISH = "Do you like English?";
	public static final String COMPUTERS = "Do you like using computers?";
	public static final String BUILDING = "Do you like building things?";
	public static final String GOODBYE_MESSAGE = "Thank you. Goodbye.";

		// ------------------------- DO NOT MODIFY ABOVE -------------------------
    
		// IMPLEMENT YOUR SOLUTION HERE
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); //scanner variable created
		System.out.println(WELCOME_MESSAGE);
		System.out.println(ALREADY_KNOW);
		String alreadyKnow = scanner.nextLine(); //whether they know major
		switch(alreadyKnow) 
		{
	    case("Yes"):
	    	System.out.println(GOODBYE_MESSAGE);
	        break;
	    case("No"): 
	    	System.out.println(MATH);
			String math = scanner.nextLine(); //whether they like math
			if(math.equals("Yes"))
			{
				System.out.println(COMPUTERS);
				String computers = scanner.nextLine(); //whether they like computers
				if(computers.equals("Yes"))
				{
					System.out.println("Computer Science");
				}
				else if(computers.equals("No"))
				{
					System.out.println(BUILDING);
					String building = scanner.nextLine(); //whether they like building
					if(building.equals("Yes"))
					{
						System.out.println("Engineering");
					}
					else if(building.equals("No"))
					{
						System.out.println(SCIENCES);
						String sciences = scanner.nextLine(); //whether they like science
						if(sciences.equals("Yes"))
						{
							System.out.println("Natural Sciences");
						}
						else if(sciences.equals("No"))
						{
							System.out.println("Math");
						}
					}
				}
			}
			else if(math.equals("No"))
			{
				System.out.println(PEOPLE);
				String people = scanner.nextLine(); //whether they like talking to people
				if(people.equals("Yes"))
				{
					System.out.println(TEACHING);
					String teaching = scanner.nextLine(); //whether they like teaching
					if(teaching.equals("Yes"))
					{
						System.out.println("Education");
					}
					else if(teaching.equals("No"))
					{
						System.out.println(SCIENCES);
						String sciences = scanner.nextLine(); //whether they like science
						if(sciences.equals("Yes"))
						{
							System.out.println("Medicine");
						}
						else if(sciences.equals("No"))
						{
							System.out.println(MONEY);
							String money = scanner.nextLine(); //whether they think about making money
							if(money.equals("Yes"))
							{
								System.out.println("Business");
							}
							else if(money.equals("No"))
							{
								System.out.println("Psychology");
							}
						}
					}
				}
				else if(people.equals("No"))
				{
					System.out.println(LANGUAGES);
					String languages = scanner.nextLine(); //whether they like languages
					if(languages.equals("Yes"))
					{
						System.out.println(ENGLISH);
						String english = scanner.nextLine(); //whether they like english
						if(english.equals("Yes"))
						{
							System.out.println("English");
						}
						else if(english.equals("No"))
						{
							System.out.println("Foreign Languages");
						}
					}
					else if(languages.equals("No"))
					{
						System.out.println("Art");
					}
				}
			}
			break;
		}
	}				

   
	    /*
		System.out.println(MATH);
		String math = scanner.nextLine();
		System.out.println(PEOPLE);
		String people = scanner.nextLine();
		System.out.println(TEACHING);
		String teaching = scanner.nextLine();
		System.out.println(SCIENCES);
		String sciences = scanner.nextLine();
		System.out.println(MONEY);
		String money = scanner.nextLine();
		System.out.println(LANGUAGES);
		String languages = scanner.nextLine();
		System.out.println(ENGLISH);
		String english = scanner.nextLine();
		System.out.println(COMPUTERS);
		String computers = scanner.nextLine();
		System.out.println(BUILDING);
		String building = scanner.nextLine();
		System.out.println(GOODBYE_MESSAGE);
		*/	
}		
