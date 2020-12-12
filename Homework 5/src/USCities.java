import java.util.Scanner;

public class USCities 
{
    public static void main (String[] args) 
    {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a String of ten cities separated by commas.");
        String cities = scan.nextLine();
        System.out.println(cities); //remove later
        for (int i = 0; i < 10; i++) 
        {
            String currentCity = "";
            if(i != 9) 
            {
                int index = cities.indexOf(",");
                currentCity = cities.substring(0, index);
                if (currentCity.substring(0,1).compareTo("N") >= 0) 
                {
                    System.out.println(currentCity);
                    
                }
                cities = cities.substring(index + 1);
            } 
            else
            {
                    currentCity = cities;
                    if (currentCity.substring(0,1).compareTo("N") >= 0) 
                    {
                      System.out.println(currentCity);
                    }
           
            }
        }
    }
}
