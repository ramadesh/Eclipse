import java.util.Scanner;
/**
 * A program that asks for a String of fruits separated by commas from the user
 * and checks the fruits listed for alphabetical order
 * to find the odd one out that doesn't follow 
 * alphabetical order
 *
 * @author Rama Deshpande, CS180 Merge
 * @version September 27, 2020
 */
public class OddFruitOut 
{
    public static void main(String[] args) 
    {
    	Scanner scan = new Scanner(System.in); //scanner created
        String welcome = "Hello, welcome to the Odd Fruit Out game!";
        String prompt = "Please enter a String of fruits separated by commas.";
        String result = "The odd fruit out is fruit number ";
        String nextFruit; //will later be modified to find the fruit after the current one being checked
        
        System.out.println(welcome);
        System.out.println(prompt);
        String fruitsInput = scan.nextLine(); //user inputs fruits
        
        int numFruits = 1; //initialized as 1, but tracks the number of fruits listed
        
        //finds the number of fruits listed by user with commas
        for (int i = 0; i < fruitsInput.length(); i++)
        {
        	
        	if (fruitsInput.substring(i, i + 1).equals(","))
        	{
        		numFruits++;
        	}
        }
        
        /*
         * checks each fruit with the next one listed for alphabetical comparison
         * announces when one is wrong
         */
        for(int i = 1; i <= numFruits; i++)
        {
        	if(i < numFruits)
        	{
        		int index = fruitsInput.indexOf(",");
        		String currentFruit = fruitsInput.substring(0, index); //finds the first fruit that is being checked
        		fruitsInput = fruitsInput.substring(index + 1);
        		if (fruitsInput.indexOf(",") == -1)
        		{
        			nextFruit = fruitsInput.substring(0, fruitsInput.length());
        		}
        		else
        		{
        			nextFruit = fruitsInput.substring(0, fruitsInput.indexOf(","));
        		}
        		if (nextFruit.compareTo(currentFruit) < 0)
        		{
        			System.out.println(result + (i + 1) + ": " + nextFruit);
        			break;
        		}
        	}
        }
    }
}
