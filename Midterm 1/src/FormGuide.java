import java.util.Scanner;
public class FormGuide 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //scanner created
		
		String formString = "";
		double formScore = 0;
		int pointsEarned = 0;
		double goalsScored = 0;
		double goalsConceded = 0;
		
		System.out.println("Enter team name: ");
		String teamName = scan.nextLine();
		System.out.println("Enter 1 or 2 for warehouse: ");
		int numMatchesPlayed = scan.nextInt();
		scan.nextLine();
		System.out.println("Matches: ");
		String match1 = scan.nextLine();
		int match1Home = Integer.valueOf(match1.substring(match1.length()-3, match1.length()-2));
		int match1Away = Integer.valueOf(match1.substring(match1.length()-1, match1.length()));
		if (match1Home > match1Away)
		{
			formString += "W";
		}
		else if (match1Home < match1Away)
		{
			formString += "L";
		}
		else if (match1Home == match1Away)
		{
			formString += "D";
		}
		String match2 = scan.nextLine();
		int match2Home = Integer.valueOf(match2.substring(match2.length()-3, match2.length()-2));
		int match2Away = Integer.valueOf(match2.substring(match2.length()-1, match2.length()));
		if (match2Home > match2Away)
		{
			formString += "W";
		}
		else if (match2Home < match2Away)
		{
			formString += "L";
		}
		else if (match2Home == match2Away)
		{
			formString += "D";
		}
		
		String match3 = scan.nextLine();
		int match3Home = Integer.valueOf(match3.substring(match3.length()-3, match3.length()-2));
		int match3Away = Integer.valueOf(match3.substring(match3.length()-1, match3.length()));
		if (match3Home > match3Away)
		{
			formString += "W";
		}
		else if (match3Home < match3Away)
		{
			formString += "L";
		}
		else if (match3Home == match3Away)
		{
			formString += "D";
		}
		
		String match4 = scan.nextLine();
		int match4Home = Integer.valueOf(match4.substring(match4.length()-3, match4.length()-2));
		int match4Away = Integer.valueOf(match4.substring(match4.length()-1, match4.length()));
		if (match4Home > match4Away)
		{
			formString += "W";
		}
		else if (match4Home < match4Away)
		{
			formString += "L";
		}
		else if (match4Home == match4Away)
		{
			formString += "D";
		}
		
		String match5 = scan.nextLine();
		int match5Home = Integer.valueOf(match5.substring(match5.length()-3, match5.length()-2));
		int match5Away = Integer.valueOf(match5.substring(match5.length()-1, match5.length()));
		if (match5Home > match5Away)
		{
			formString += "W";
		}
		else if (match5Home < match5Away)
		{
			formString += "L";
		}
		else if (match5Home == match5Away)
		{
			formString += "D";
		}
		
		String match6 = scan.nextLine();
		int match6Home = Integer.valueOf(match6.substring(match6.length()-3, match6.length()-2));
		int match6Away = Integer.valueOf(match6.substring(match6.length()-1, match6.length()));
		if (match6Home > match6Away)
		{
			formString += "W";
		}
		else if (match6Home < match6Away)
		{
			formString += "L";
		}
		else if (match6Home == match6Away)
		{
			formString += "D";
		}
		
		String resultScore = "";
		String homeAwayScore = "";
		for(int i =0; i < formString.length(); i++)
		{
			if (formString.substring(i, i+1).equals("W"))
			{
				resultScore += 2;
				if (i == 0)
				{
					if (match1.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				if (i == 1)
				{
					if (match2.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				if (i == 2)
				{
					if (match3.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				if (i == 3)
				{
					if (match4.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				if (i == 4)
				{
					if (match5.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				if (i == 5)
				{
					if (match6.indexOf(teamName) == 0)
					{
						homeAwayScore += "1";
					}
					else
					{
						homeAwayScore += "1.5";
					}
				}
				
			}
			if (formString.substring(i, i+1).equals("L"))
			{
				resultScore += 2;
				if (i == 0)
				{
					if (match1.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				if (i == 1)
				{
					if (match2.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				if (i == 2)
				{
					if (match3.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				if (i == 3)
				{
					if (match4.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				if (i == 4)
				{
					if (match5.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				if (i == 5)
				{
					if (match6.indexOf(teamName) == 0)
					{
						homeAwayScore += "1.5";
					}
					else
					{
						homeAwayScore += "1";
					}
				}
				
			}
			else if (formString.substring(i, i+1).equals("L"))
			{
				resultScore += -2;
			}
			
		}
		
		for(int i = 0; i < formString.length(); i++)
		{
			if (formString.substring(i, i+1).equals("W"))
			{
				pointsEarned += 3;
			}
			else if (formString.substring(i, i+1).equals("W"))
			{
				pointsEarned += 1;
			}
			else
			{
				pointsEarned += 0;
			}
		}
		System.out.println("Points earned: " + pointsEarned);
		
		if (match1.indexOf(teamName) == 0)
		{
			goalsScored += match1Home;
		}
		if (match2.indexOf(teamName) == 0)
		{
			goalsScored += match2Home;
		}
		else if (match3.indexOf(teamName) == 0)
		{
			goalsScored += match3Home;
		}
		else if (match4.indexOf(teamName) == 0)
		{
			goalsScored += match4Home;
		}
		else if (match5.indexOf(teamName) == 0)
		{
			goalsScored += match5Home;
		}
		else if (match6.indexOf(teamName) == 0)
		{
			goalsScored += match6Home;
		}
		else if (match1.indexOf(teamName) != 0)
		{
			goalsConceded += match1Away;
		}
		if (match2.indexOf(teamName) != 0)
		{
			goalsConceded += match2Away;
		}
		else if (match3.indexOf(teamName) == 0)
		{
			goalsConceded += match3Away;
		}
		else if (match4.indexOf(teamName) == 0)
		{
			goalsConceded += match4Away;
		}
		else if (match5.indexOf(teamName) == 0)
		{
			goalsConceded += match5Away;
		}
		else if (match6.indexOf(teamName) == 0)
		{
			goalsConceded += match6Away;
		}
		System.out.println("Team Name: " + teamName);
		System.out.println("Form String: " + formString);
		System.out.println("Goals scored: "+ goalsScored);
		System.out.println("Goals conceded: "+ goalsConceded);
	}

}
