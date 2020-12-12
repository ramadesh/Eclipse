import java.util.Scanner;
/**
 * A program that takes a math expression as a string from the user
 * and answers it
 * and converts the digits from the result into letters
 * and modifies them
 * to get the answer to the puzzle
 *
 * @author Rama Deshpande, CS180 Merge
 * @version September 28, 2020
 */
public class Puzzle {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //scanner created
        System.out.println("Enter the equation:");
		String str = scan.nextLine();
		int result = 0; //output from the math expression
		int strAsInt; //first num from the math expression
		int strAsInt2;//second num from the math expression
		String puzzle = ""; //to be used for the switch statement to decode digits 
		
		for (int i = 0; i < str.length(); i++)
		{
			String currentLetter = str.substring(i, i+1); //the letter being checked in for loop
			if(currentLetter.equals("+"))
			{
				strAsInt = Integer.valueOf(str.substring(0, i));
				strAsInt2 = Integer.valueOf(str.substring(i+1, str.length()));
				result = strAsInt + strAsInt2;
			}
			else if (currentLetter.equals("-"))
			{
				strAsInt = Integer.valueOf(str.substring(0, i));
				strAsInt2 = Integer.valueOf(str.substring(i+1, str.length()));
				result = strAsInt - strAsInt2;
			}
			else if (currentLetter.equals("*"))
			{
				strAsInt = Integer.valueOf(str.substring(0, i));
				strAsInt2 = Integer.valueOf(str.substring(i+1, str.length()));
				result = strAsInt * strAsInt2;
			}
			else if (currentLetter.equals("/"))
			{
				strAsInt = Integer.valueOf(str.substring(0, i));
				strAsInt2 = Integer.valueOf(str.substring(i+1, str.length()));
				result = strAsInt / strAsInt2;
			}
		}
		
		String resultString = String.valueOf(result); //string version of result from math expression
		String puzzleComplete = ""; //the final answer to the puzzle
		String consonants = ""; //the consonants at the beginning of the code
		for (int i = 0; i < resultString.length(); i++)
		{
			puzzle = switch (resultString.substring(i, i+1))
			{
			case "0" -> "a";
			case "1" -> "b";
			case "2" -> "c";
			case "3" -> "d";
			case "4" -> "e";
			case "5" -> "f";
			case "6" -> "g";
			case "7" -> "h";
			case "8" -> "i";
			default -> "j";
			};
			puzzleComplete += puzzle;
		}
		if (puzzleComplete.substring(0, 1).equals("a")
				|| puzzleComplete.substring(0, 1).equals("e")
				|| puzzleComplete.substring(0, 1).equals("i")
				|| puzzleComplete.substring(0, 1).equals("o")
				|| puzzleComplete.substring(0, 1).equals("u"))
		{
			puzzleComplete += "-yay";
		}
		else
		{
			for (int i = 0; i < puzzleComplete.length(); i++)
			{
				if (!puzzleComplete.substring(0, 1).equals("a")
						&& !puzzleComplete.substring(0, 1).equals("e")
						&& !puzzleComplete.substring(0, 1).equals("i")
						&& !puzzleComplete.substring(0, 1).equals("o")
						&& !puzzleComplete.substring(0, 1).equals("u"))
				{
					
					consonants += puzzleComplete.substring(0, 1);
					puzzleComplete = puzzleComplete.substring(1);
				}	
			}
			puzzleComplete = puzzleComplete + "-" + consonants + "ay";
		}
		
		System.out.println("The answer to the puzzle is " + puzzleComplete);
	}
}
