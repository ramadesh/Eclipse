/**
 * A class that stores information about a given book
 * including its name, author, edition, price, quantity, and ratings
 * and has methods to modify certain attributes of the book
 *
 * @author Rama Deshpande, CS180 Merge
 * @version October 5, 2020
 */
public class Book {
	private String bookName;
	private String author;
	private int edition;
	private double price;
	private int quantityAvailable;
	private double averageRating;
	private int numberOfRatings;
	
	public Book(String bookName, 
			  String author, 
			  int edition, 
			  double price, 
			  int quantityAvailable, 
			  double averageRating, 
			  int numberOfRatings)
	{
		this.bookName = bookName;
		this.author = author;
		this.edition = edition;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
		this.averageRating = averageRating;
		this.numberOfRatings = numberOfRatings;
	}

	public double calculateDiscount(int quantity)
	{
		
        double totalPrice = quantity * price; //is used to compute total price to calculate discount.
		if (totalPrice >= 0 && totalPrice < 10)
		{
			return 0;
		} else if (totalPrice >= 10 && totalPrice < 13)
		{
			return 0.1;
		} else if (totalPrice >= 13 && totalPrice < 15)
		{
			return 0.2;
		} else if (totalPrice >= 15 && totalPrice < 20)
		{
			return 0.3;
		} else
		{
			return 0.4;
		}
	}
	public double purchaseBook(int quantity)
	{
		double finalPrice;
        double discount = calculateDiscount(quantity);
		if (quantityAvailable < quantity)
		{
			finalPrice = price * quantityAvailable * (1.0 - discount);
			quantityAvailable = 0;
		} else
		{
			finalPrice = price * quantity * (1.0 - discount);
			quantityAvailable -= quantity;
		}
		return finalPrice;
	}
	public void replaceBook(Book book)
	{
		this.bookName = book.bookName;
		this.author = book.author;
		this.edition = book.edition;
		this.price = book.price;
		this.quantityAvailable = book.quantityAvailable;
		this.averageRating = book.averageRating;
		this.numberOfRatings = book.numberOfRatings;
		
	}
	public void changePrice(double newprice)
	{
		price = newprice;
	}
	public void rateBook(int rating)
	{
		averageRating = ((averageRating * numberOfRatings) + rating) / (numberOfRatings + 1);
		numberOfRatings++;
	}
	public void restock(int quantity)
	{
		quantityAvailable += quantity;
	}
	public String getBookName()
	{
		return bookName;
	}
	public String getAuthor()
	{
		return author;
	}
	public int getEdition()
	{
		return edition;
	}
	public double getPrice()
	{
		return price;
	}
	public int getQuantityAvailable()
	{
		return quantityAvailable;
	}
	public double getAverageRating()
	{
		return averageRating;
	}
	public int getNumberOfRatings()
	{
		return numberOfRatings;
	}
	public String toString()
	{
		return  "Book Name : " + bookName + '\n' +
                "Author: " + author + '\n' +
                "Edition: " + edition + '\n' +
                "Price: $" + price + '\n' +
                "Quantity Available: " + quantityAvailable + '\n' +
                "Average Rating: " + averageRating + '\n' +
                "Number Of Ratings: " + numberOfRatings;
	}
	public boolean equals(Object o)
	{
		if (this == o) 
		{
            return true;
        }
        if (o instanceof Book) 
        {
            Book book = (Book) o;
            return this.bookName.equals(book.getBookName()) &&
                    this.author.equals(book.getAuthor()) &&
                    this.edition == book.getEdition() &&
                    this.price == book.getPrice() &&
                    this.quantityAvailable == book.getQuantityAvailable() &&
                    this.averageRating == book.getAverageRating() &&
                    this.numberOfRatings == book.getNumberOfRatings();
        }
        return false;
	}
}