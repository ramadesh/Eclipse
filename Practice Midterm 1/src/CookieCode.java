import java.util.Scanner;
public class CookieCode {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //scanner created
		System.out.println("Enter 1 or 2 for warehouse: ");
		String warehouseNum = scan.nextLine();
		warehouseNum = "W" + warehouseNum;
		
		System.out.println("Enter packaged date: ");
		String packDate = scan.nextLine();
		packDate = packDate.substring(0, 2) + packDate.substring(3);
		
		System.out.println("Enter expiration date: ");
		String expirationDate = scan.nextLine();
		expirationDate = expirationDate.substring(0, 2) + expirationDate.substring(3);
		
		System.out.println("Enter flavor number: ");
		String flavor = scan.nextLine();;
		String chocolateType;
		if(flavor.equals("1"))
		{
			System.out.println("Enter chocolate flavor type: ");
			chocolateType = scan.nextLine();
			if(chocolateType.equals("1"))
			{
				chocolateType = "D";
			}
			else
			{
				chocolateType = "R";
			}
		}
		
		String flavorLetter = switch (flavor)
		{
			case "1" -> "C";
			case "2" -> "O";
			case "3" -> "A";
			case "4" -> "B";
			default -> "S";
		};
		
		//now creating the identification code below
		System.out.println("Enter item name: ");
		String itemName = scan.nextLine();
		int middleIndex;
		if(itemName.length() % 2 == 1)
		{
			middleIndex = itemName.length()/2;
			itemName = itemName.substring(0, middleIndex)+ itemName.substring(middleIndex + 1, itemName.length());
		}
		middleIndex = itemName.length()/2;
		itemName = itemName.substring(middleIndex, itemName.length())+ itemName.substring(0, middleIndex);
		
		System.out.println("Enter total production number: ");
		int prodNum = scan.nextInt();
		scan.nextLine();
		prodNum++;
		String prodNumString = String.valueOf(prodNum);
		String firstFiveCharOfID = prodNumString.substring(prodNumString.length() - 5, prodNumString.length());
		
		String sixthCharOfID = itemName.substring(itemName.length() - 1, itemName.length());
		sixthCharOfID = sixthCharOfID.toUpperCase();
		
		String seventhCharOfID = itemName.substring(1, 2);
		seventhCharOfID = seventhCharOfID.toUpperCase();
		
		String restCharsOfID = prodNumString.substring(0, 2);
		
		String id = firstFiveCharOfID + sixthCharOfID + seventhCharOfID + restCharsOfID;
		System.out.println(warehouseNum + packDate + expirationDate + flavorLetter + id);
	}

}
