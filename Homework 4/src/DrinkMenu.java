import java.util.Scanner; 

/**
 * A program that calculates a user's drink order! 
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Homework 04 -- Walkthrough</p>
 *
 * @author Purdue CS 
 * @version August 24, 2020
 */
public class DrinkMenu {
    public static void main(String[] args) {
        int totalPrice = 0; 
        Scanner scan = new Scanner(System.in); 

        System.out.println("Would you like to order?");
        System.out.println("1. Water"); 
        System.out.println("2. Hot Tea");
        System.out.println("3. Soda");
        System.out.println("4. Coffee");
        
        int drink = scan.nextInt();
        scan.nextLine();
        if (drink == 1)
        {
        	totalPrice = 1;
        	System.out.println("Your total is: $" + totalPrice); 
        }
        else if (drink == 2)
        {
        	totalPrice = 3;
        	System.out.println("Your total is: $" + totalPrice); 
        }
        else if (drink == 3)
        {
        	totalPrice = 2;
        	System.out.println("Your total is: $" + totalPrice); 
        }
        else if (drink == 4)
        {
        	totalPrice = 5;
        	System.out.println("Your total is: $" + totalPrice); 
        }
        else
        {
        	System.out.println("Error! Choose an item on the menu!"); 
        }


    }
}