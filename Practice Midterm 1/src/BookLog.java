import java.util.Scanner;
public class BookLog 
{
	private Book fiction;
	private Book nonfiction;
	Scanner scanner = new Scanner(System.in);

	public Book getFiction()
	{
		return fiction;
	}
	
	public void setFiction(Book fiction)
	{
		this.fiction = fiction;
	}
	
	public Book getNonfiction()
	{
		return nonfiction;
	}
	
	public void setNonfiction(Book nonfiction)
	{
		this.nonfiction = nonfiction;
	}
	
	public void add(String input)
	{
		if (input.substring(0, 1) == "F")
		{
			this.fiction.setBookList(input);
			Book bookFiction = new Book("", 'F', Double.valueOf(input.substring(input.lastIndexOf("-") + 1)));
		}
		else
		{
			this.nonfiction.setBookList(input);
			Book bookNonfiction = new Book("", 'F', Double.valueOf(input.substring(input.lastIndexOf("-") + 1)));
		}
		System.out.println("Added!");
	}
	public void search(String input)
	{
		String bookList = this.nonfiction.getBookList();
		String bookList2 = this.fiction.getBookList();
		if (bookList.indexOf(input) != -1 || bookList2.indexOf(input) != -1)
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not found!");
		}
	}
	
	public void closeApp()
	{
		
	}
	public void menu()
	{
		System.out.println("Press 1 to add.");
		System.out.println("Press 2 to search.");
		System.out.println("Or press 3 to close app.");
		int menuChoice = scanner.nextInt();
		scanner.nextLine();
		while(menuChoice != 3)
		{
			if (menuChoice == 1)
			{
				System.out.println("What would you like to add?");
				String addThis = scanner.nextLine();
				add(addThis);
			}
			else if (menuChoice == 2)
			{
				System.out.println("What would you like to search for?");
				String searchThis = scanner.nextLine();
				search(searchThis);
			}
			else
			{
				closeApp();
			}
		}
	}

}
