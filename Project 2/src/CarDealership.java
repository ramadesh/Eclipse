import java.util.Scanner;
/**
 * A class that works with car objects and performs services
 *
 *
 * @author Rama Deshpande 
 * @version Oct 19, 2020
 */
public class CarDealership 
{
	private Car carOne;
	private Car carTwo;
	private Car carThree;
	private double dailyTransactions;
	private Car[] inventory = new Car[0];
	
	public CarDealership(Car carOne, Car carTwo, Car carThree)
	{
		this.carOne = carOne;
		this.carTwo = carTwo;
		this.carThree = carThree;
		this.inventory = new Car[]{carOne, carTwo, carThree};
	}
	public CarDealership()
	{
		
	}
	public void performMaintenance(Scanner scan)
	{
		System.out.println("Welcome to the Maintenance menu!");
		System.out.println("Please select the service you wish to record:");
		System.out.println("1. Oil Change ($50)");
		System.out.println("2. Tire Rotation ($30)");
		System.out.println("3. Detailing ($100)");
		System.out.println("4. Tune-up ($200)");
		int maintenence = scan.nextInt();
		scan.nextLine();
		while (maintenence >= 1 && maintenence <= 4)
		{	
			if (maintenence == 1)
			{
				dailyTransactions += 50;
			} else if (maintenence == 2)
			{
				dailyTransactions += 30;
			} else if (maintenence == 3)
			{
				dailyTransactions += 100;
			} else if (maintenence == 4)
			{
				dailyTransactions += 200;
			}
			System.out.println("Your selection has been recorded!");
			System.out.println("Did you sell another service?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int maintenenceAgain = scan.nextInt();
			scan.nextLine();
			while (maintenenceAgain != 2)
			{
				if (maintenenceAgain == 1)
				{
					System.out.println("Please select the service you wish to record:");
					System.out.println("1. Oil Change ($50)");
					System.out.println("2. Tire Rotation ($30)");
					System.out.println("3. Detailing ($100)");
					System.out.println("4. Tune-up ($200)");
					maintenence = scan.nextInt();
					scan.nextLine();
					break;
				} else
				{
					System.out.println("An error occurred!");
				}
			}
			if (maintenenceAgain == 2)
			{
				System.out.println("Thank you! Now returning to the Main Menu...");
				return;
			}
		}
	}
	
	public void sellCar(Scanner scan)
	{
		String sold;
		System.out.println("Welcome to the Sales Menu!");
		if (inventory.length == 0)
		{
			System.out.println("No vehicles currently available.");
			System.out.println("Thank you! Now returning to the Main Menu...");
			return;
		}
		if (inventory.length > 0)
		{
			printInventory();
			System.out.println("Did you sell a vehicle?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int sell = scan.nextInt();
			scan.nextLine();
			while (sell == 1 && inventory.length >= 1)
			{
				System.out.print("Which vehicle was sold? ");
                System.out.println("Please enter the Make, Model, and Year separated by commas.");
				sold = scan.nextLine();
				String[] carInfo = sold.split(",");
				Car[] smallerInventory = new Car[inventory.length - 1];
				int j = 0;
				for (int i = 0; i < inventory.length; i++)
				{
					if (carInfo[0] != inventory[i].getMake() 
                        && carInfo[1] != inventory[i].getModel() 
                        && Integer.parseInt(carInfo[2]) != inventory[i].getYear())
					{
						smallerInventory[j] = inventory[i];
						j++;
					}
					if (j == inventory.length - 1)
					{
						System.out.println("An error occurred!");
						return;
					}
					
				}
				inventory = new Car[smallerInventory.length];
				inventory = smallerInventory;
				dailyTransactions += 15000;
				System.out.println("The vehicle list has been updated!");
				printInventory();
				while (inventory.length > 0)
				{
					System.out.println("Did you sell another vehicle?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					sell = scan.nextInt();
					scan.nextLine();
					if (sell != 1 && sell != 2)
					{
						System.out.println("An error occurred!");
						return;
					}
					break;
				}
				if (inventory.length == 0)
				{
					System.out.println("No vehicles currently available.");
					System.out.println("Thank you! Now returning to the Main Menu...");
					return;
				}
			} 
			if (sell == 2)
			{
				System.out.println("Thank you! Now returning to the Main Menu...");
				return;
			} else
			{
				System.out.println("An error occurred!");
				return;
			}
		} 
		else if (inventory.length == 0)
		{
			System.out.println("No vehicles currently available.");
			System.out.println("Thank you! Now returning to the Main Menu...");
			return;
		}
	}
	
	public void buyCar(Scanner scan)
	{
		System.out.println("Welcome to the Purchasing Menu!");
		if (inventory.length > 0)
		{
			printInventory();
		}
		if (inventory.length == 3)
		{
			System.out.println("The Vehicle Inventory is now full.");
			return;
		}
		System.out.println("Did you purchase a vehicle?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int purchased = scan.nextInt();
		scan.nextLine();
		while (purchased == 1 && inventory.length < 3)
		{
			System.out.println("Please enter the Vehicle Details!");
			System.out.println("Make:");
			String theMake = scan.nextLine();
			System.out.println("Model:");
			String theModel = scan.nextLine();
			System.out.println("Year:");
			int theYear = scan.nextInt();
			scan.nextLine();
			Car car = new Car(theMake, theModel, theYear);
			Car[] newInventory = new Car[inventory.length + 1];
			for (int i = 0; i < inventory.length; i++)
			{
				newInventory[i] = inventory[i];
			}
			newInventory[inventory.length] = car;
			inventory = new Car[newInventory.length];
			inventory = newInventory;
			if (carOne == null)
			{
				carOne = car;
			} else if (carTwo == null)
			{
				carTwo = car;
			} else if (carThree == null)
			{
				carThree = car;
			}
			printInventory();
			dailyTransactions -= 10000;
			while (inventory.length < 3)
			{
				System.out.println("Did you purchase another vehicle?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				purchased = scan.nextInt();
				scan.nextLine();
				if (purchased != 1 && purchased != 2)
				{
					System.out.println("An error occurred!");
					return;
				}
				break;
			}
			if (inventory.length == 3)
			{
				System.out.println("The Vehicle Inventory is now full.");
				System.out.println("Thank you! Now returning to the Main Menu...");
				return;
			}
		}
		if (purchased == 2)
		{
			System.out.println("Thank you! Now returning to the Main Menu...");
			return;
		} else if (purchased != 1 && purchased != 2)
		{
			System.out.println("An error occurred!");
			return;
		}
		
	}
	
	public void printInventory()
	{
		if (inventory.length > 0)
		{
			System.out.println("Current Inventory is Listed Below:");
			if (carOne != null)
			{
				System.out.println(carOne.toString());
			}
			if (carTwo != null)
			{
				System.out.println(carTwo.toString());
			}
			if (carThree != null)
			{
				System.out.println(carThree.toString());
			}
		} else
		{
			System.out.println("Current Inventory is Listed Below:");
		}
	}
	
	public void menu()
	{
		Scanner scan = new Scanner(System.in);
		int menuChoice = 0;
		while (menuChoice != 5)
		{
			System.out.println("Welcome to the Main Menu!");
			System.out.printf("The Daily Transactions value is currently: $%.2f", dailyTransactions);
			System.out.println();
			System.out.println("Please select an Option:");
			System.out.println("1. Perform Maintenance");
			System.out.println("2. Sell Car");
			System.out.println("3. Buy Car");
			System.out.println("4. Print Inventory");
			System.out.println("5. Quit");
			menuChoice = scan.nextInt();
			scan.nextLine();
			if (menuChoice >= 1 && menuChoice <= 4)
			{
				if (menuChoice == 1)
				{
					performMaintenance(scan);
				}
				if (menuChoice == 2)
				{
					sellCar(scan);
				}
				if (menuChoice == 3)
				{
					buyCar(scan);
				}
				if (menuChoice == 4)
				{
					printInventory();
				}
			}
		}
        if ((menuChoice < 1 || menuChoice > 4) && menuChoice != 5)
		{
			System.out.println("An error occurred!");
			return;
		}
		System.out.println("Thank you for using the Car Dealership program!");
		
		
	}
	public static void main(String[] args) 
	{
		System.out.print("Which vehicle was sold? ");
		System.out.println("Please enter the Make, Model, and Year separated by commas.");
		System.out.println("The vehicle list has been updated!");
	}
}

